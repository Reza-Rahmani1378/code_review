package com.vasl.code_review.service.remote.api.model;

import lombok.Data;

import java.util.List;

@Data
public class MagfaRequestBody {
    private List<String> messages;
    private List<String> recipients;
}
