package com.vasl.code_review.service.sms;

import com.vasl.code_review.service.mapper.SmsMapper;
import com.vasl.code_review.service.model.CompleteSmsModel;
import com.vasl.code_review.service.remote.api.client.SmsTwilioApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwilioSmsService implements SmsService {

    private final SmsTwilioApi smsTwilioApi;
    private final SmsMapper smsMapper;



    @Override
    public void sendSimple(CompleteSmsModel completeSmsModel) {
        smsTwilioApi.sendSimple(
                completeSmsModel.getUsername(),
                completeSmsModel.getPassword(),
                completeSmsModel.getShortNumber(),
                completeSmsModel.getMobile() ,
                completeSmsModel.getMessage()
        );
    }

    @Override
    public boolean support(SmsAgent smsAgent) {
        return SmsAgent.TWILIO.equals(smsAgent);
    }
}
