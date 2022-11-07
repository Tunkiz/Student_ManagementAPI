package com.bookshop.BookShop.models.exceptions;

import java.text.MessageFormat;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(final Long id){
        super(MessageFormat.format("Cannot find genre with id: {0}", id));
    }
}
