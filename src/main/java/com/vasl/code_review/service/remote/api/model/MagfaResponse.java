package com.vasl.code_review.service.remote.api.model;

import lombok.Data;

import java.util.List;

@Data
public class MagfaResponse {
    private Integer status;
    private List<MagfaMessage> messages;
}
