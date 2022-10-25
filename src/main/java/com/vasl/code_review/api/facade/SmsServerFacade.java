package com.vasl.code_review.api.facade;

import com.vasl.code_review.api.dto.SmsServerInputModel;
import com.vasl.code_review.api.dto.SmsServerOutputModel;
import com.vasl.code_review.api.facade.mapper.SmsServerFacadeMapper;
import com.vasl.code_review.dal.entity.SmsServer;
import com.vasl.code_review.service.SmsServerService;
import com.vasl.connect.utils.crud.api.model.PageQueryParams;
import com.vasl.connect.utils.crud.dal.RepositoryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SmsServerFacade {

    private final SmsServerService service;
    private final SmsServerFacadeMapper mapper;
    public SmsServerOutputModel create(SmsServerInputModel smsServerInputModel) {
        SmsServer smsServer = mapper.getEntityFromSmsServerInputModel(smsServerInputModel);
        smsServer = service.create(smsServer);
        return mapper.getSmsServerOutputModelFromEntity(smsServer);
    }


    public void update(SmsServerInputModel smsServerInputModel, String id) {
        SmsServer smsServer = mapper.getEntityFromSmsServerInputModelAndId(smsServerInputModel , id);
        service.update(smsServer);
    }

    public void delete(String id) {
        service.deleteById(id);
    }

    public SmsServerOutputModel getSmsServer(String id) {
        return mapper.getSmsServerOutputModelFromEntity(
                service.getById(id)
        );
    }

    public Page<SmsServerOutputModel> getPage(PageQueryParams pageQueryParams) {
        Pageable pageable = RepositoryUtils.getPageableFromPageQueryParams(pageQueryParams);
        return service.getPage(pageable).map(mapper::getSmsServerOutputModelFromEntity);

    }

    public void activateSmsServer(String id) {
        service.activateThisOneAndDeactivateOthers(id);
    }
}
