package com.joicelima.EmailService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joicelima.EmailService.application.EmailSenderService;
import com.joicelima.EmailService.core.exceptions.EmailServiceException;

@RestController
@RequestMapping("api/email")
public class EmailSenderController {
    private final EmailSenderService emailSenderService;



@Autowired
   public EmailSenderController(EmailSenderService emailService){
    this.emailSenderService = emailService;
   } 

@PostMapping()
 public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
    try{
        this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
        return ResponseEntity.ok("Email send sucessfully")
    } catch(EmailServiceException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
    }
 } 

}
