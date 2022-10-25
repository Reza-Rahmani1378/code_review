package com.vasl.code_review.api.dto;

import com.vasl.code_review.service.sms.SmsAgent;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SmsServerInputModel {
    @ApiModelProperty(example = "'KAVE_NEGAR'")
    private SmsAgent smsAgent;
    @ApiModelProperty(example = "'1000596446'")
    private String shortNumber;
    @ApiModelProperty(example = "'https://api.kavenegar.com/v1/6362557965644E54612B7951546679346734676B4B42576E58786969752B356A/sms/send.json'")
    private String url;
    @ApiModelProperty(example = "'test_username'")
    private String username;
    @ApiModelProperty(example = "'test_password'")
    private String password;
    @ApiModelProperty(example = "true")
    private Boolean active = false;
}
