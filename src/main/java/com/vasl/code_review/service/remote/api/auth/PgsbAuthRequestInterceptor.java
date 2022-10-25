package com.vasl.code_review.service.remote.api.auth;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.stereotype.Component;

@Component
public class PgsbAuthRequestInterceptor extends BasicAuthRequestInterceptor {

    public PgsbAuthRequestInterceptor() {
        super("vezaratkeshvarClient", "AuP6wjY7qJ7YwpCc");
    }
}