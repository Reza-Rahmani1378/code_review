package com.vasl.code_review.service;

import com.vasl.code_review.dal.entity.MailServer;
import com.vasl.code_review.dal.repository.MailServerRepository;
import com.vasl.code_review.service.mapper.MailServerServiceMapper;
import com.vasl.connect.utils.crud.service.SimpleCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleMailServerService extends SimpleCRUDService<MailServer> implements MailServerService{

    private final MailServerRepository repository;
//    private final MailServerServiceMapper mapper;

    public SimpleMailServerService(MailServerRepository repository) {
        super(repository , MailServerServiceMapper.INSTANCE);
        this.repository = repository;
    }


    @Override
    public void activateThisMailServerAndThenDeactivateOthers(String id) {
        activate(id);
        deactivateOtherMailServers(id);
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
}
