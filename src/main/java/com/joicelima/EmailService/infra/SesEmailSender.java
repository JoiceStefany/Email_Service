package com.joicelima.EmailService.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.joicelima.EmailService.adapters.EmailSenderGateway;
import com.joicelima.EmailService.core.exceptions.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {

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
            .withMessage(new Message()
               .withSubject(new Content(subject))
               .withBody(new Body().withText(new Content(body))));

               try {
                this.amazonSimpleEmailService.sendEmail(request);
               } catch(AmazonServiceException exception) {
                    throw new EmailServiceException("Failure while seding email", exception);
               }
            
    } 

    }
    
    

