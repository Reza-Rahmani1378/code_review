package com.vasl.code_review.service.remote.api.model;

import lombok.Data;

@Data
public class MagfaMessage {
    private Integer status;
    private Long id;
    private Long userId;
    private Integer parts;
    private Double tariff;
    private String recipient;
}
