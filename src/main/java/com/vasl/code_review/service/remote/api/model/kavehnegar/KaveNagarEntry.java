package com.vasl.code_review.service.remote.api.model.kavehnegar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KaveNagarEntry {
    @JsonProperty("messageid")
    private Long messageId;
    private String message;
    private Integer status;
    @JsonProperty("statustext")
    private String statusText;
    private String sender;
    private String receptor;
    private Long date;
    private Integer cost;
}