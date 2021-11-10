package com.comp.contactmanager.domain.exception;

public class InvalidCompanyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCompanyException(String message) {
        super(message);
    }

}
