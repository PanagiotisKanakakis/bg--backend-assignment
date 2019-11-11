package com.blueground.assignment.exception;


import com.blueground.assignment.error.UserError;

public class ConfigurationException extends RestException {

    public ConfigurationException(UserError userError) {
        super(userError.getDescription());
    }
}
