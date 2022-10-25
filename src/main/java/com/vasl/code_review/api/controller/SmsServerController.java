package com.vasl.code_review.api.controller;

import com.vasl.code_review.api.dto.SmsServerInputModel;
import com.vasl.code_review.api.dto.SmsServerOutputModel;
import com.vasl.code_review.api.facade.SmsServerFacade;
import com.vasl.connect.utils.crud.api.model.PageQueryParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/code_review/sms-server")
@RequiredArgsConstructor
public class SmsServerController {

    private final SmsServerFacade facade;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create sms server")
    public SmsServerOutputModel create(@RequestBody @Validated SmsServerInputModel smsServerInputModel) {
        return facade.create(smsServerInputModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "update sms server")
    public void update(@RequestBody @Validated SmsServerInputModel smsServerInputModel , @PathVariable("id") String id) {
        facade.update(smsServerInputModel , id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "delete sms server")
    public void delete(@PathVariable("id") String id) {
        facade.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "get sms server by id")
    public SmsServerOutputModel getSmsServer(@PathVariable("id") String id) {
        return facade.getSmsServer(id);
    }

    @GetMapping
    @ApiOperation(value = "get page sms server")
    public Page<SmsServerOutputModel> getPage(PageQueryParams pageQueryParams) {
        return facade.getPage(pageQueryParams);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateSmsServer(@PathVariable("id") String id) {
        facade.activateSmsServer(id);
    }




}
