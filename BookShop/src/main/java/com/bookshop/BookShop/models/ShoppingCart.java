package com.bookshop.BookShop.models;

import com.bookshop.BookShop.models.dto.CartDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();
    public void addBook(OrderItem orderItem){
        items.add(orderItem);
    }

    public void deleteBook(OrderItem orderItem){
        items.remove(orderItem);
    }
    public static ShoppingCart from(CartDto cartDto){
        ShoppingCart cart = new ShoppingCart();
        cart.setId(cartDto.getId());
        cart.setUserId(cartDto.getUserId());
        return cart;
    }
}
