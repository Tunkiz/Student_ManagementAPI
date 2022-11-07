package com.darkCoders.CodeRe.models.exceptions;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(long id){
        super(MessageFormat.format("Could not found user with: {0}", id));
    }
}
