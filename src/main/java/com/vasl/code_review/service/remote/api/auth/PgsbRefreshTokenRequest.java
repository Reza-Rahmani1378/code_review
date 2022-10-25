package com.vasl.code_review.service.remote.api.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PgsbRefreshTokenRequest {

    @Builder.Default
    private String grant_type = "refresh_token";
    @JsonProperty("refresh_token")
    private String refresh_token;

}
