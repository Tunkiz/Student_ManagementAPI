package com.bookshop.BookShop.models.exceptions;

import java.text.MessageFormat;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(final Long id){
        super(MessageFormat.format("Cannot find author with id: {0}", id));
    }
}
