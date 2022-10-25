package com.vasl.code_review.api.facade.mapper;

import com.vasl.code_review.api.dto.SendMailInputModel;
import com.vasl.code_review.api.dto.SendSmsInputModel;
import com.vasl.code_review.service.model.SimpleMailModel;
import com.vasl.code_review.service.model.SimpleSmsModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface MessagingFacadeMapper {

    SimpleMailModel getSimpleMailModelFromSendMailInputModel(SendMailInputModel sendMailInputModel);

    SimpleSmsModel getSimpleSmsModelFromSendSmsInputModel(SendSmsInputModel sendSmsInputModel);
}
