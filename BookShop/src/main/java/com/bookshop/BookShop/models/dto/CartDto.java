package com.bookshop.BookShop.models.dto;

import com.bookshop.BookShop.models.ShoppingCart;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartDto {
    private Long id;
    private String userId;
    private List<BookDto> books = new ArrayList<>();

    public static CartDto from(ShoppingCart cart){
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setUserId(cart.getUserId());
        cartDto.setBooks(cart.getBooks().stream().map(BookDto::from).collect(Collectors.toList()));
        return cartDto;
    }
}
