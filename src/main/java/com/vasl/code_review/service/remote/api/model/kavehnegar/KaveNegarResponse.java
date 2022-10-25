package com.vasl.code_review.service.remote.api.model.kavehnegar;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class KaveNegarResponse {

    @JsonProperty("return")
    private KaveNegarReturn returnValue;
    private List<KaveNagarEntry> entries;

}
