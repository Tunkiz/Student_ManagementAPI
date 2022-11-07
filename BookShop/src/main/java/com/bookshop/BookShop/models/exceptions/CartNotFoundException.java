package com.bookshop.BookShop.models.exceptions;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(final Long id){
        super(MessageFormat.format("Cannot find cart with id: {0}", id));
    }
}
