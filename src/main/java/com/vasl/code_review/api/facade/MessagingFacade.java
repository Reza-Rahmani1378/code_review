package com.vasl.code_review.api.facade;

import com.vasl.code_review.api.dto.SendMailInputModel;
import com.vasl.code_review.api.dto.SendSmsInputModel;
import com.vasl.code_review.api.facade.mapper.MessagingFacadeMapper;
import com.vasl.code_review.service.MessagingService;
import com.vasl.code_review.service.model.SimpleMailModel;
import com.vasl.code_review.service.model.SimpleSmsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessagingFacade {

    private final MessagingFacadeMapper mapper;
    private final MessagingService service;
    public void sendMail(SendMailInputModel sendMailInputModel) {
        SimpleMailModel simpleMailModel = mapper.getSimpleMailModelFromSendMailInputModel(sendMailInputModel);
        service.sendSimpleMail(simpleMailModel , sendMailInputModel.getMailServerId());
    }

    public void sendSms(SendSmsInputModel sendSmsInputModel) {
        SimpleSmsModel simpleSmsModel = mapper.getSimpleSmsModelFromSendSmsInputModel(sendSmsInputModel);
        service.sendSimpleSms(simpleSmsModel , sendSmsInputModel.getSmsServerId());
    }
}
