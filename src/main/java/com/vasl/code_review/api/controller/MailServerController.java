package com.vasl.code_review.api.controller;

import com.vasl.code_review.api.dto.MailServerInputModel;
import com.vasl.code_review.api.dto.MailServerOutputModel;
import com.vasl.code_review.api.facade.MailServerFacade;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/code_review/mail-server")
@RequiredArgsConstructor
public class MailServerController {

    private final MailServerFacade facade;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiModelProperty(value = "create mail server")
    public MailServerOutputModel create(@RequestBody MailServerInputModel mailServerInputModel) {
        return facade.create(mailServerInputModel);
    }
}
