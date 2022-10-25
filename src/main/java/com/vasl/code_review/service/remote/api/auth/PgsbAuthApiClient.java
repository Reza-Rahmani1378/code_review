package com.vasl.code_review.service.remote.api.auth;

import com.vasl.connect.utils.crud.service.remote.DefaultFeignErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "pgsb-auth-api-client", url = "${pgsb.base.url}", configuration = DefaultFeignErrorDecoder.class)
public interface PgsbAuthApiClient {

    @PostMapping(path = "${pgsb.auth.url}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    PgsbGetTokenResponse getToken(PgsbGetTokenRequest pgsbGetTokenRequest);

    @PostMapping(path = "${pgsb.auth.url}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    PgsbGetTokenResponse refreshToken(PgsbRefreshTokenRequest pgsbRefreshTokenRequest);

}