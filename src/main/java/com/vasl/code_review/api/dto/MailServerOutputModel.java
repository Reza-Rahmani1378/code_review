package com.vasl.code_review.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel
public class MailServerOutputModel extends MailServerInputModel implements Serializable {
    @ApiModelProperty(example = "1234567890")
    private String id;
}
