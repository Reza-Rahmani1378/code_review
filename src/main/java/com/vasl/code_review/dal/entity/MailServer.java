package com.vasl.code_review.dal.entity;


import com.vasl.code_review.service.mail.MailProtocol;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "mailServer")
public class MailServer{
    private String host;
    private Integer port;
    private String username;
    private String password;
    private Boolean startTls;
    private MailProtocol mailProtocol;
    private Boolean auth = true;
    private Boolean active = false;
}
