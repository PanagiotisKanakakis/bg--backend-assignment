package com.blueground.assignment.exception;

import com.blueground.assignment.error.UserError;

public class AuthenticationException extends RestException {

    public AuthenticationException(UserError userError) {
        super(userError.getDescription());
    }
}
