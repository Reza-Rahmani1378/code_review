package com.vasl.code_review.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class SendMailInputModel {
    @NotBlank(message = "{general.not.blank}")
    @ApiModelProperty(example = "'1234567890'")
    private String mailServerId;
    @NotBlank(message = "{general.not.blank}")
    @ApiModelProperty(example = "'test@gmail.com'")
    private String to;
    @ApiModelProperty(example = "'subject'")
    private String subject;
    @NotNull(message = "{general.not.null}")
    @ApiModelProperty(example = "'text'")
    private String text;
}
