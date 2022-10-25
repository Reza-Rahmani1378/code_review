package com.vasl.code_review.dal.entity;

import com.vasl.code_review.service.sms.SmsAgent;
import com.vasl.connect.utils.crud.dal.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "smsServer")
public class SmsServer extends Entity {
    private SmsAgent smsAgent;
    private String shortNumber;
    private String url;
    private String username;
    private String password;
    private Boolean active = false;
}
