package com.vasl.code_review.service.remote.api.auth;

import com.vasl.connect.utils.crud.service.remote.FeignGeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PgsbAuthAdapter implements AuthAdapter {

    private final PgsbAuthApiClient apiClient;
    private final PgsbGetTokenRequest getTokenRequest;
    private String accessToken;
    private String refreshToken;

    public PgsbAuthAdapter(PgsbAuthApiClient apiClient, PgsbGetTokenRequest getTokenRequest) {
        this.apiClient = apiClient;
        this.getTokenRequest = getTokenRequest;
    }

    @Override
    public String getToken(){
        //lazy load
        if (Objects.isNull(accessToken)) {
            getTokenAndSetAccessAndRefresh();
        }
        return accessToken;
    }

    @Override
    public void refreshToken(){
        if (Objects.nonNull(refreshToken)){
            try{
                getTokenByRefreshAndSetAccessAndRefresh();
            }catch (FeignGeneralException e){
                if (e.getStatus().equals(HttpStatus.UNAUTHORIZED.value()) || e.getStatus().equals(HttpStatus.BAD_REQUEST.value()))
                    getTokenAndSetAccessAndRefresh();
                else
                    throw new FeignGeneralException(e);
            }
        }else {
            getTokenAndSetAccessAndRefresh();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    private synchronized void getTokenAndSetAccessAndRefresh() {
        PgsbGetTokenResponse tokenResponse = apiClient.getToken(getTokenRequest);
        setAccessAndRefresh(tokenResponse);
    }


    private synchronized void getTokenByRefreshAndSetAccessAndRefresh() {
        PgsbGetTokenResponse tokenResponse = apiClient.refreshToken(
                PgsbRefreshTokenRequest.builder().refresh_token(refreshToken).build()
        );
        setAccessAndRefresh(tokenResponse);
    }

    private synchronized void setAccessAndRefresh(PgsbGetTokenResponse tokenResponse) {
        accessToken = tokenResponse.getAccessToken();
        refreshToken = tokenResponse.getRefreshToken();
    }

}
