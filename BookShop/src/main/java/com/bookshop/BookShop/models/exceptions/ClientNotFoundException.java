package com.bookshop.BookShop.models.exceptions;

import java.text.MessageFormat;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(final Long id){
        super(MessageFormat.format("Cannot find genre with id: {0}", id));
    }
}
