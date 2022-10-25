package com.vasl.code_review.service;

import com.vasl.code_review.dal.entity.SmsServer;
import com.vasl.connect.utils.crud.service.CRUDService;

public interface SmsServerService extends CRUDService<SmsServer> {

    SmsServer getActive();
    void activateThisOneAndDeactivateOthers(String id);

}
