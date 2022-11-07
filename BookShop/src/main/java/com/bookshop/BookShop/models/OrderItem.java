package com.bookshop.BookShop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    private String id;
    @OneToOne
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_ID", nullable = false)
    @JsonIgnore
    private ShoppingCart cart;
    private int quantity;

    public void fromDto(Book p, ShoppingCart cart, int quantity){
        id = UUID.randomUUID().toString().replace("-", "");
        book =p;
        this.cart = cart;
        this.quantity =quantity;
    }
}
