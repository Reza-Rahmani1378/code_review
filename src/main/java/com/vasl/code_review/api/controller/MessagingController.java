package com.vasl.code_review.api.controller;

import com.vasl.code_review.api.dto.SendMailInputModel;
import com.vasl.code_review.api.facade.MessagingFacade;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/code_review/messaging")
@RequiredArgsConstructor
public class MessagingController {

    private final MessagingFacade facade;


    @PostMapping("/mail")
    @ApiOperation(value = "send mail")
    public void sendMail(@RequestBody SendMailInputModel sendMailInputModel) {
        facade.sendMail(sendMailInputModel);
    }




}
