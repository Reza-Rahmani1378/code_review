package com.vasl.code_review.service.mapper;

import com.vasl.code_review.dal.entity.MailServer;
import com.vasl.connect.utils.crud.service.CRUDServiceMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR , componentModel = "spring")
public interface MailServerServiceMapper extends CRUDServiceMapper<MailServer> {

//    MailServerServiceMapper INSTANCE = Mappers.getMapper(MailServerServiceMapper.class);
}
