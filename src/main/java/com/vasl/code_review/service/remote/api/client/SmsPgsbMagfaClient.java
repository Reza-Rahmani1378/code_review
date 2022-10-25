package com.vasl.code_review.service.remote.api.client;

import com.vasl.code_review.service.remote.api.model.MagfaRequestBody;
import com.vasl.code_review.service.remote.api.model.MagfaResponse;
import com.vasl.connect.utils.crud.service.remote.DefaultFeignErrorDecoder;
import com.vasl.connect.utils.crud.service.remote.model.PgsbResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.URI;

@FeignClient(name = "magfa-api-client", configuration = DefaultFeignErrorDecoder.class)
public interface SmsPgsbMagfaClient {
    @PostMapping(headers = {"pid=${pgsb.auth.magfa.pid}", "API_KEY=${pgsb.auth.magfa.api-key}"})
    PgsbResponse<MagfaResponse> sendOne(
            URI uri,
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody MagfaRequestBody body
    );
}
