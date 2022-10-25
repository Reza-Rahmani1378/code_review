package com.vasl.code_review.service;

import com.vasl.code_review.dal.entity.SmsServer;
import com.vasl.code_review.dal.repository.SmsServerRepository;
import com.vasl.code_review.service.mapper.SmsServerServiceMapper;
import com.vasl.code_review.service.message.ErrorMessages;
import com.vasl.connect.utils.crud.service.NotFoundException;
import com.vasl.connect.utils.crud.service.SimpleCRUDService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleSmsServerService extends SimpleCRUDService<SmsServer> implements SmsServerService{

    private final SmsServerRepository smsServerRepository;
    private final SmsServerServiceMapper serviceMapper;

    public SimpleSmsServerService(SmsServerRepository smsServerRepository , SmsServerServiceMapper serviceMapper) {
        super(smsServerRepository, serviceMapper);
        this.smsServerRepository = smsServerRepository;
        this.serviceMapper = serviceMapper;
    }

    @Override
    public SmsServer getActive() {
        return getActiveEntity();
    }

    @Override
    public void activateThisOneAndDeactivateOthers(String id) {
        activate(id);
        deactivateOthers(id);
    }


    private void activate(String id) {
        SmsServer smsServer = getById(id);
        smsServer.setActive(true);
        smsServerRepository.save(smsServer);
    }

    private void deactivateOthers(String id) {
        List<SmsServer> entityList = getList().stream()
                .filter(smsServerInfo -> smsServerInfo.getActive() && !smsServerInfo.getId().equals(id))
                .peek(smsServerInfo -> smsServerInfo.setActive(false))
                .collect(Collectors.toList());
        smsServerRepository.saveAll(entityList);
    }

    private SmsServer getActiveEntity() {
        return smsServerRepository.findByActive(true)
                .orElseThrow( () -> new NotFoundException(ErrorMessages.NOT_FOUND_ENTITY));
    }

}
