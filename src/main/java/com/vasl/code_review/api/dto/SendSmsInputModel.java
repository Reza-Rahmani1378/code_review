package com.vasl.code_review.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class SendSmsInputModel implements Serializable {
    @ApiModelProperty(example = "'1234567890'")
    @Pattern(regexp = " {0,2}(\\d)")
    private String smsServerId;
    @NotBlank(message = "{general.not.blank}")
    @Pattern(regexp = "(0|\\+98)?( |-|[()]){0,2}9\\d( |-|[()]){0,2}(?:\\d( |-|[()]){0,2}){8}", message = "{mobile.not.correct}")
    @ApiModelProperty(example = "'09911049181'")
    private String mobile;
    @NotNull(message = "{general.not.null}")
    @ApiModelProperty(example = "'message'")
    private String message;
}
