package com.vasl.code_review.service.remote.api.client;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmsTwilioApiSdkImpl implements SmsTwilioApi{

    private final static Logger LOGGER = LoggerFactory.getLogger(SmsTwilioApiSdkImpl.class);
    @Override
    public Message sendSimple(String username, String password, String shortNumber, String mobile, String body) {
        String ACCOUNT_SID = username;
        String AUTH_TOKEN = password;
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(mobile), new PhoneNumber(shortNumber), body).create();
        LOGGER.info(message.toString());
        return message;
    }
}