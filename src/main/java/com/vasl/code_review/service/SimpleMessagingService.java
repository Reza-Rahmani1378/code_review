package com.vasl.code_review.service;

import com.vasl.code_review.api.facade.MessagingFacade;
import com.vasl.code_review.service.mail.MailServiceFacade;
import com.vasl.code_review.service.model.CompleteMailModel;
import com.vasl.code_review.service.model.CompleteSmsModel;
import com.vasl.code_review.service.model.SimpleMailModel;
import com.vasl.code_review.service.model.SimpleSmsModel;
import com.vasl.code_review.service.sms.SmsServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SimpleMessagingService implements MessagingService{

    private final MailServiceFacade mailServiceFacade;
    private final SmsServiceFacade smsServiceFacade;


    @Override
    @Transactional
    public void sendSimpleMail(SimpleMailModel simpleMailModel, String mailServerId) {
        CompleteMailModel completeMailModel = new CompleteMailModel(simpleMailModel);
        mailServiceFacade.getServiceAndUpdateModel(mailServerId,completeMailModel).sendSimple(completeMailModel);
    }

    @Override
    public void sendSimpleSms(SimpleSmsModel simpleSmsModel, String smsServerId) {
        CompleteSmsModel completeSmsModel = new CompleteSmsModel(simpleSmsModel);
        smsServiceFacade.getServiceAndUpdateModel(smsServerId, completeSmsModel).sendSimple(completeSmsModel);

    }
}
