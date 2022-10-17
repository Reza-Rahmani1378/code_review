package com.vasl.code_review.api.facade;

import com.vasl.code_review.api.dto.MailServerInputModel;
import com.vasl.code_review.api.dto.MailServerOutputModel;
import com.vasl.code_review.api.facade.mapper.MailServerFacadeMapper;
import com.vasl.code_review.dal.entity.MailServer;
import com.vasl.code_review.service.MailServerService;
import com.vasl.connect.utils.crud.api.model.PageQueryParams;
import com.vasl.connect.utils.crud.dal.RepositoryUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailServerFacade {

    private final MailServerService service;
    private final MailServerFacadeMapper mapper;


    public MailServerOutputModel create(MailServerInputModel mailServerInputModel) {
        MailServer mailServer = mapper.getEntityFromInputModel(mailServerInputModel);
        mailServer = service.create(mailServer);
        return mapper.getOutputModelFromEntity(mailServer);

    }

    public void update(MailServerInputModel mailServerInputModel, String id) {
        MailServer mailServer = mapper.getEntityFromInputModelAndId(mailServerInputModel , id);
        service.update(mailServer);
    }

    public void delete(String id) {
        service.deleteById(id);
    }

    public MailServerOutputModel get(String id) {
        MailServer mailServer = service.getById(id);
        return mapper.getOutputModelFromEntity(mailServer);
    }

    public Page<MailServerOutputModel> getPage(PageQueryParams pageQueryParams) {
        Pageable pageable = RepositoryUtils.getPageableFromPageQueryParams(pageQueryParams);
        return service.getPage(pageable).map(mapper ::getOutputModelFromEntity);

    }

    public void activate(String id) {
        service.activateThisMailServerAndThenDeactivateOthers(id);
    }
}
