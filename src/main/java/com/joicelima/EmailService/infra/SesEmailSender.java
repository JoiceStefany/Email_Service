package com.joicelima.EmailService.infra;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.joicelima.EmailService.adapters.EmailSenderGateway;

public class SesEmailSender implements EmailSenderGateway{

    private final AmazonSimpleEmailService amazonSimpleEmailService;


    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
            .withSource("steffanyjoice006@gmail.com")
            .withDestination(new Destination().withToAddresses(to))
            .withMessage(new Message());
            
    }
    
}
