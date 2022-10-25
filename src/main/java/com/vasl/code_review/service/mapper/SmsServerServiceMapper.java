package com.vasl.code_review.service.mapper;

import com.vasl.code_review.dal.entity.SmsServer;
import com.vasl.connect.utils.crud.service.CRUDServiceMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR , componentModel = "spring")
public interface SmsServerServiceMapper extends CRUDServiceMapper<SmsServer> {
}
