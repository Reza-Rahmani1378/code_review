package com.vasl.code_review.service;

import com.vasl.code_review.service.model.SimpleMailModel;

public interface MessagingService {

    void sendSimpleMail(SimpleMailModel simpleMailModel , String mailServerId);
}
