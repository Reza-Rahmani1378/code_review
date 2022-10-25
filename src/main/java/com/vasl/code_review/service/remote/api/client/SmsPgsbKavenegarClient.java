package com.vasl.code_review.service.remote.api.client;

import com.vasl.code_review.service.remote.api.model.kavehnegar.KaveNegarResponse;
import com.vasl.code_review.service.remote.api.model.kavehnegar.PgsbKaveNegarRequest;
import com.vasl.connect.utils.crud.service.remote.DefaultFeignErrorDecoder;
import com.vasl.connect.utils.crud.service.remote.model.PgsbResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.URI;

@FeignClient(name = "pgsb-kavenegar-api-client", configuration = DefaultFeignErrorDecoder.class)
public interface SmsPgsbKavenegarClient {
    @PostMapping(headers = "pid=${pgsb.auth.kavenagar.pid}")
    PgsbResponse<KaveNegarResponse> sendOne(
            URI uri,
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody PgsbKaveNegarRequest body
    );
}
