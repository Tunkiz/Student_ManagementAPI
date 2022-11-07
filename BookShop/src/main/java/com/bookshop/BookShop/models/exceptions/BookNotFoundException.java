package com.bookshop.BookShop.models.exceptions;

import java.text.MessageFormat;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(final Long id){
        super(MessageFormat.format("Cannot find book with id: {0}", id));
    }
}
