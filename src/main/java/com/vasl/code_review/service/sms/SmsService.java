package com.vasl.code_review.service.sms;

import com.vasl.code_review.service.model.CompleteSmsModel;

public interface SmsService {
    void sendSimple(CompleteSmsModel completeSmsModel);

    boolean support(SmsAgent smsAgent);
}
