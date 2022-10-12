package com.vasl.code_review.api.dto;




import com.vasl.code_review.service.mail.MailProtocol;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel
public class MailServerInputModel implements Serializable {
    @NotBlank(message = "{general.not.blank}")
    @ApiModelProperty(example = "'smtp.gmail.com'")
    private String host;
    @NotNull(message = "{general.not.null}")
    @ApiModelProperty(example = "587")
    private Integer port;
    @NotBlank(message = "{general.not.blank}")
    @ApiModelProperty(example = "'dev.vahid01@gmail.com'")
    private String username;
    @NotBlank(message = "{general.not.blank}")
    @ApiModelProperty(example = "'the_password'")
    private String password;
    @NotNull(message = "{general.not.null}")
    @ApiModelProperty(example = "true")
    private Boolean startTls;
    @ApiModelProperty(example = "true")
    private Boolean active = false;
    @ApiModelProperty(example = "'SMTP'")
    private MailProtocol mailProtocol = MailProtocol.SMTP;
}
