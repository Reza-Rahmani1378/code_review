package com.vasl.code_review.service.model;

import com.vasl.code_review.service.sms.SmsAgent;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompleteSmsModel extends SimpleSmsModel {
    private SmsAgent smsAgent;
    private String shortNumber;
    private String url;
    private String username;
    private String password;

    public CompleteSmsModel(SimpleSmsModel simpleSmsModel) {
        super(simpleSmsModel.getMobile(), simpleSmsModel.getMessage());
    }
}
