package com.vasl.code_review.api.facade.mapper;

import com.vasl.code_review.api.dto.SmsServerInputModel;
import com.vasl.code_review.api.dto.SmsServerOutputModel;
import com.vasl.code_review.dal.entity.SmsServer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR , componentModel = "spring")
public interface SmsServerFacadeMapper {

    SmsServer getEntityFromSmsServerInputModel(SmsServerInputModel smsServerInputModel);

    SmsServerOutputModel getSmsServerOutputModelFromEntity(SmsServer smsServer);

    SmsServer getEntityFromSmsServerInputModelAndId(SmsServerInputModel smsServerInputModel , String id);
}
