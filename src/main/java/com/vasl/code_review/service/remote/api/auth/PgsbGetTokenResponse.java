package com.vasl.code_review.service.remote.api.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class PgsbGetTokenResponse implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private Long expireIn;
    private String scope;
    @JsonIgnore
    private ZonedDateTime accessTokenExpirationTime;
    @JsonIgnore
    private ZonedDateTime refreshTokenExpirationTime;

}
