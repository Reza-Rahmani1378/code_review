package com.vasl.code_review.service.mapper;

import com.vasl.code_review.dal.entity.MailServer;
import com.vasl.code_review.service.model.CompleteMailModel;
import com.vasl.connect.utils.crud.service.CRUDServiceMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR , componentModel = "spring")
public interface MailMapper extends CRUDServiceMapper<MailServer> {

    JavaMailSenderImpl getMailSenderFromCompleteEmailModel(CompleteMailModel completeMailModel);

    @Mapping(target = "to", ignore = true)
    SimpleMailMessage getSimpleMailMessageFromCompleteMailModel(CompleteMailModel completeMailModel);

    void updateCompleteMailModelByMailServer(@MappingTarget CompleteMailModel completeMailModel, MailServer mailServer);
}
