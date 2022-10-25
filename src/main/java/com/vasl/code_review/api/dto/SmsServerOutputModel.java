package com.vasl.code_review.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel
public class SmsServerOutputModel extends SmsServerInputModel{
    @ApiModelProperty(example = "123456789")
    private String id;
}
