package com.vasl.code_review.api.controller;

import com.vasl.code_review.api.dto.MailServerInputModel;
import com.vasl.code_review.api.dto.MailServerOutputModel;
import com.vasl.code_review.api.facade.MailServerFacade;
import com.vasl.connect.utils.crud.api.model.PageQueryParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/code_review/mail-server")
@RequiredArgsConstructor
public class MailServerController {

    private final MailServerFacade facade;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create mail server")
    public MailServerOutputModel createMailServer(@RequestBody @Validated MailServerInputModel mailServerInputModel) {
        return facade.create(mailServerInputModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "update mail server")
    public void updateMailServer(@RequestBody @Validated MailServerInputModel mailServerInputModel , @PathVariable("id") @ApiParam(name = "id" , example = "1234565") String id) {
        facade.update(mailServerInputModel , id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "delete mail server")
    public void deleteMailServer(@PathVariable("id") @ApiParam(name = "id" , example = "123456789") String id) {
        facade.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "get mail server by id")
    public MailServerOutputModel getMailServer(@PathVariable String id) {
        return facade.get(id);
    }

    @GetMapping
    @ApiOperation(value = "get page mail server")
    public Page<MailServerOutputModel> getMailServersPage(PageQueryParams pageQueryParams) {
        return facade.getPage(pageQueryParams);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateMailServer(@PathVariable("id") @ApiParam(name = "id" , example = "123456789") String id) {
        facade.activate(id);
    }


}
