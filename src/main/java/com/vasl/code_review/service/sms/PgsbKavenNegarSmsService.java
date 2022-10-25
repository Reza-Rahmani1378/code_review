package com.vasl.code_review.service.sms;

import com.vasl.code_review.service.mapper.SmsMapper;
import com.vasl.code_review.service.model.CompleteSmsModel;
import com.vasl.code_review.service.remote.api.auth.AuthAdapter;
import com.vasl.code_review.service.remote.api.client.SmsPgsbKavenegarClient;
import com.vasl.connect.utils.crud.service.remote.FeignGeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class PgsbKavenNegarSmsService implements SmsService {

    private final SmsMapper smsMapper;
    private final SmsPgsbKavenegarClient client;
    private final AuthAdapter authAdapter;



    @Override
    public void sendSimple(CompleteSmsModel completeSmsModel) {
        try{
            String token = authAdapter.getToken();
            client.sendOne(
                    URI.create(completeSmsModel.getUrl()),
                    "Bearer " + token,
                    smsMapper.getPgsbKavenegarRequestFromCompleteSmsModel(completeSmsModel)
            );
        }catch (FeignGeneralException e){
            if (e.getStatus() == HttpStatus.UNAUTHORIZED.value()){
                authAdapter.refreshToken();
                sendSimple(completeSmsModel);
            }else
                throw new FeignGeneralException(e);
        }
    }

    @Override
    public boolean support(SmsAgent smsAgent) {
        return SmsAgent.PGSB_KAVE_NEGAR.equals(smsAgent);
    }
}
