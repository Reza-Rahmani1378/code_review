package com.vasl.code_review.service.remote.api.client;

import com.twilio.rest.api.v2010.account.Message;

public interface SmsTwilioApi {
    Message sendSimple(String username, String password, String shortNumber, String mobile, String message);
}
