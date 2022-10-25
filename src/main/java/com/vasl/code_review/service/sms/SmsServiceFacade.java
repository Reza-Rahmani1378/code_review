package com.vasl.code_review.service.sms;

import com.vasl.code_review.dal.entity.SmsServer;
import com.vasl.code_review.service.SmsServerService;
import com.vasl.code_review.service.mapper.SmsMapper;
import com.vasl.code_review.service.model.CompleteSmsModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SmsServiceFacade {

    private final SmsServerService smsServerService;
    private final List<SmsService> smsServices;
    private final SmsMapper smsMapper;

    public SmsService getServiceAndUpdateModel(String smsServerId, CompleteSmsModel completeSmsModel) {
        SmsServer smsServer = Objects.isNull(smsServerId) ? smsServerService.getActive() : smsServerService.getById(smsServerId);
        SmsService smsService = getProperService(smsServer.getSmsAgent());
        smsMapper.updateSimpleSmsModelBySmsServerInfo(completeSmsModel , smsServer);
        return smsService;
    }


    private SmsService getProperService(SmsAgent smsAgent) {
        for (SmsService smsService : smsServices) {
            if (smsService.support(smsAgent))
                return smsService;
        }
        throw new IllegalStateException("Unexpected value: " + smsAgent.name());
    }
}
