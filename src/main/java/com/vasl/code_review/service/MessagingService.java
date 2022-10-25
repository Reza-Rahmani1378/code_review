package com.vasl.code_review.service;

import com.vasl.code_review.service.model.SimpleMailModel;
import com.vasl.code_review.service.model.SimpleSmsModel;

public interface MessagingService {

    void sendSimpleMail(SimpleMailModel simpleMailModel , String mailServerId);

    void sendSimpleSms(SimpleSmsModel simpleSmsModel, String smsServerId);
}
