package com.vasl.code_review.service.mail;


import com.vasl.code_review.service.mapper.MailMapper;
import com.vasl.code_review.service.model.CompleteMailModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class SmtpGeneralMailService implements MailService {

    private final MailMapper mailMapper;

    @Override
    public void sendSimple(CompleteMailModel completeMailModel){
        JavaMailSender javaMailSender = getMailSender(completeMailModel);
        SimpleMailMessage message = mailMapper.getSimpleMailMessageFromCompleteMailModel(completeMailModel);
        javaMailSender.send(message);
    }

    @Override
    public boolean support(MailProtocol mailProtocol) {
        return mailProtocol.equals(MailProtocol.SMTP);
    }

/*    @Override
    public boolean support(MailProtocol mailProtocol) {
        return mailProtocol.equals(MailProtocol.SMTP);
    }




 */

    public JavaMailSender getMailSender(CompleteMailModel completeMailModel) {
        JavaMailSenderImpl javaMailSender = mailMapper.getMailSenderFromCompleteEmailModel(completeMailModel);
        // other properties
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", completeMailModel.getAuth().toString());
        props.put("mail.smtp.starttls.enable", completeMailModel.getStartTls().toString());
        props.put("mail.debug", "true");
        return javaMailSender;
    }


}
