package com.vasl.code_review.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleMailModel {
    private String to;
    private String subject;
    private String text;
}
