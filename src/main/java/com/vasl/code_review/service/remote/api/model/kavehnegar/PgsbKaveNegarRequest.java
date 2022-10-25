package com.vasl.code_review.service.remote.api.model.kavehnegar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PgsbKaveNegarRequest {
    @JsonProperty("receptor")
    private String receiver;
    @JsonProperty("token")
    private String message;
}
