package com.vasl.code_review.service.mail;

import com.vasl.code_review.service.model.CompleteMailModel;

public interface MailService {

    void sendSimple(CompleteMailModel completeMailModel);

    boolean support(MailProtocol mailProtocol);
}
