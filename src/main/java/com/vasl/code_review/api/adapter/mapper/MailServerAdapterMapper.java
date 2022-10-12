package com.vasl.code_review.api.adapter.mapper;

import com.vasl.code_review.api.dto.MailServerInputModel;
import com.vasl.code_review.dal.entity.MailServer;
import org.mapstruct.Mapper;

@Mapper
public interface MailServerAdapterMapper{

    MailServer getEntityFromInputModel(MailServerInputModel mailServerInputModel);
}
