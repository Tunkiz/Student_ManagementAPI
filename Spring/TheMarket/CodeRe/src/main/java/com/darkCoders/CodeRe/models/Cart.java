package com.darkCoders.CodeRe.models;

import com.darkCoders.CodeRe.models.dtos.CartDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "cart")
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product product){
        products.add(product);
    }
    public void removeProduct(Product product){
        products.remove(product);
    }
    public void clearCart(){
        products.clear();
    }

    public static Cart from(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setId(cartDTO.getId());
        cart.setUser(cartDTO.getUser());
        return cart;
    }
}
