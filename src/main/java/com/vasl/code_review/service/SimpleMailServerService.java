package com.vasl.code_review.service;

import com.vasl.code_review.dal.entity.MailServer;
import com.vasl.code_review.dal.repository.MailServerRepository;
import com.vasl.code_review.service.mapper.MailServerServiceMapper;
import com.vasl.connect.utils.crud.service.SimpleCRUDService;
import org.springframework.stereotype.Service;

@Service
public class SimpleMailServerService extends SimpleCRUDService<MailServer> implements MailServerService{

    private final MailServerRepository repository;
//    private final MailServerServiceMapper mapper;

    public SimpleMailServerService(MailServerRepository repository) {
        super(repository , MailServerServiceMapper.INSTANCE);
        this.repository = repository;
    }


}
