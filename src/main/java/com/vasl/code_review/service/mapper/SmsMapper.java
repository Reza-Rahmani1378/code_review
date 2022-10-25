package com.vasl.code_review.service.mapper;

import com.vasl.code_review.dal.entity.SmsServer;
import com.vasl.code_review.service.model.CompleteSmsModel;
import com.vasl.code_review.service.remote.api.model.MagfaRequestBody;
import com.vasl.code_review.service.remote.api.model.kavehnegar.PgsbKaveNegarRequest;
import org.mapstruct.*;

import java.net.URI;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR , componentModel = "spring")
public interface SmsMapper {

    void updateSimpleSmsModelBySmsServerInfo(@MappingTarget CompleteSmsModel completeSmsModel, SmsServer smsServer);
    default URI getUri(String url) {
        return URI.create(url);
    }

    @Mappings({
            @Mapping(target = "messages", expression = "java(List.of(completeSmsModel.getMessage()))"),
            @Mapping(target = "recipients", expression = "java(List.of(completeSmsModel.getMobile()))")
    })
    MagfaRequestBody getMagfarequestFromCompleteSmsModel(CompleteSmsModel completeSmsModel);

    @Mapping(target = "receiver", source = "mobile")
    PgsbKaveNegarRequest getPgsbKavenegarRequestFromCompleteSmsModel(CompleteSmsModel completeSmsModel);

}
