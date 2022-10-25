package com.vasl.code_review.service.mail;

import com.vasl.code_review.dal.entity.MailServer;
import com.vasl.code_review.service.MailServerService;
import com.vasl.code_review.service.mapper.MailMapper;
import com.vasl.code_review.service.model.CompleteMailModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MailServiceFacade {

    private final MailServerService mailServerService;
    private final List<MailService> mailServices;
    private final MailMapper mailMapper;
    public MailService getServiceAndUpdateModel(String mailServerId, CompleteMailModel completeMailModel) {
        MailServer mailServer = Objects.isNull(mailServerId) ? mailServerService.getActive() : mailServerService.getById(mailServerId);
        MailService mailService = getProperUpdatableMailService(mailServer.getMailProtocol());
        mailMapper.updateCompleteMailModelByMailServer(completeMailModel , mailServer);
        return mailService;
    }




    private MailService getProperUpdatableMailService(MailProtocol mailProtocol) {
        for (MailService mailService : mailServices) {
            if (mailService.support(mailProtocol)) {
                return mailService;
            }
        }
        throw new IllegalStateException("Unexpected value: " + mailProtocol.name());
    }
}
