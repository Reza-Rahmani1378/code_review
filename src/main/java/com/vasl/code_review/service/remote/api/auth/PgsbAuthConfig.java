package com.vasl.code_review.service.remote.api.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pgsb.auth")
public class PgsbAuthConfig {
    private String url;
    private String username;
    private String password;
    private String grantType;
    private String clientId;
    private String clientSecret;
}
