package com.vasl.code_review.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompleteMailModel extends SimpleMailModel {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private Boolean startTls;
    private Boolean auth;

    public CompleteMailModel(SimpleMailModel simpleMailModel) {
        super(simpleMailModel.getTo() , simpleMailModel.getSubject() , simpleMailModel.getText());
    }
}
