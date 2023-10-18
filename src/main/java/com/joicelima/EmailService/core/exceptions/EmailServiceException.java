package com.joicelima.EmailService.core.exceptions;

public class EmailServiceException extends RuntimeException {
    private static String m;

    public EmailServiceException(String message) {
        super(message);
    }

    public EmailServiceException (String message, Throwable cause){
        super(message, cause);
    }
}
