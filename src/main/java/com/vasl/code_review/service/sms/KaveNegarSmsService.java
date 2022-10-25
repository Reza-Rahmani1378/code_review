package com.vasl.code_review.service.sms;

import com.vasl.code_review.service.mapper.SmsMapper;
import com.vasl.code_review.service.model.CompleteSmsModel;
import com.vasl.code_review.service.remote.api.client.SmsKaveNegarClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KaveNegarSmsService  implements SmsService {

    private final SmsMapper smsMapper;
    private final SmsKaveNegarClient smsKaveNegarClient;

    // ------------------ biz

    @Override
    public void sendSimple(CompleteSmsModel completeSmsModel) {
        smsKaveNegarClient.sendSimple(
                smsMapper.getUri(completeSmsModel.getUrl()),
                completeSmsModel.getShortNumber(),
                completeSmsModel.getMobile(),
                completeSmsModel.getMessage(),
                "{}"
        );
    }

    @Override
    public boolean support(SmsAgent smsAgent) {
        return SmsAgent.KAVE_NEGAR.equals(smsAgent);
    }

}
