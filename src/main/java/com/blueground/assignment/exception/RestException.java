package com.blueground.assignment.exception;


public abstract class RestException extends RuntimeException {

    RestException(String errorMessage) {
        super(errorMessage);
    }

}
