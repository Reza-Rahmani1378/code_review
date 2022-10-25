package com.vasl.code_review.service.remote.api.auth;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Component
@Scope("prototype")
public class PgsbGetTokenRequest {

    private String grant_type;
    private String username;
    private String password;

    public PgsbGetTokenRequest(PgsbAuthConfig pgsbAuthConfig) {
        this.grant_type = pgsbAuthConfig.getGrantType();
        this.username = pgsbAuthConfig.getUsername();
        this.password = pgsbAuthConfig.getPassword();
    }
}
