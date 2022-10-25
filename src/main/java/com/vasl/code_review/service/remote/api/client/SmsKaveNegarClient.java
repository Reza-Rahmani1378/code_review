package com.vasl.code_review.service.remote.api.client;

import com.vasl.code_review.service.remote.api.model.kavehnegar.KaveNegarResponse;
import com.vasl.connect.utils.crud.service.remote.DefaultFeignErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@FeignClient(name = "kavenagar-api-client", configuration = DefaultFeignErrorDecoder.class)
public interface SmsKaveNegarClient {

    @PostMapping
    KaveNegarResponse sendSimple(
            URI uri,
            @RequestParam(value = "sender") String shortNumber,
            @RequestParam(value = "receptor") String mobile,
            @RequestParam(value = "message") String message,
            @RequestBody String body
    );
}
