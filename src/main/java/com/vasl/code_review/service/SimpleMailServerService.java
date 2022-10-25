package com.vasl.code_review.service;

import com.vasl.code_review.dal.entity.MailServer;
import com.vasl.code_review.dal.repository.MailServerRepository;
import com.vasl.code_review.service.mapper.MailServerServiceMapper;
import com.vasl.code_review.service.message.ErrorMessages;
import com.vasl.connect.utils.crud.service.NotFoundException;
import com.vasl.connect.utils.crud.service.SimpleCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SimpleMailServerService extends SimpleCRUDService<MailServer> implements MailServerService{

    private final MailServerRepository repository;
    private final MailServerServiceMapper mapper;

    public SimpleMailServerService(MailServerRepository repository , MailServerServiceMapper mapper) {
        super(repository , mapper);
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void activateThisMailServerAndThenDeactivateOthers(String id) {
        activate(id);
        deactivateOtherMailServers(id);
    }

    @Override
    public MailServer getActive() {
        return getActiveEntity();
    }


    private void activate(String id) {
        MailServer mailServer = getById(id);
        mailServer.setActive(Boolean.TRUE);
        repository.save(mailServer);
    }


    private void deactivateOtherMailServers(String id) {
        List<MailServer> mailServers = getList().stream()
                .filter(mailServer -> mailServer.getActive() && !mailServer.getId().equals(id))
                .peek(mailServer -> mailServer.setActive(false))
                .collect(Collectors.toList());
        repository.saveAll(mailServers);
    }

    private MailServer getActiveEntity() {
        Optional<MailServer> mailServer = repository.findByActive(true);
        if (mailServer.isPresent()) {
            return mailServer.get();
        }
        throw new NotFoundException(ErrorMessages.NOT_FOUND_ENTITY);
    }
}
