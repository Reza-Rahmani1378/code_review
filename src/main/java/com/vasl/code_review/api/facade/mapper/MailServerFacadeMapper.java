package com.vasl.code_review.api.facade.mapper;

import com.vasl.code_review.api.dto.MailServerInputModel;
import com.vasl.code_review.api.dto.MailServerOutputModel;
import com.vasl.code_review.dal.entity.MailServer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface MailServerFacadeMapper {

    MailServer getEntityFromInputModel(MailServerInputModel mailServerInputModel);

    MailServerOutputModel getOutputModelFromEntity(MailServer mailServer);

    MailServer getEntityFromInputModelAndId(MailServerInputModel mailServerInputModel, String id);
}
