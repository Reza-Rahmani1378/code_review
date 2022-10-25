package com.vasl.code_review.service.remote.api.auth;

public interface AuthAdapter {

    String getToken();
    void refreshToken();

}
