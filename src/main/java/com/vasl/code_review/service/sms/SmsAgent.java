package com.vasl.code_review.service.sms;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SmsAgent {
    @JsonProperty("KAVE_NEGAR")
    KAVE_NEGAR,
    @JsonProperty("PGSB_KAVE_NEGAR")
    PGSB_KAVE_NEGAR,
    @JsonProperty("TWILIO")
    TWILIO,
    @JsonProperty("MAGFA")
    MAGFA
}
