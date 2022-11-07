package com.darkCoders.CodeRe.services;

import com.darkCoders.CodeRe.models.Cart;
import com.darkCoders.CodeRe.repositories.CartRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServices {
    private final CartRepository cartRepository;
    @Autowired
    public CartServices(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public Cart addCart(Cart newCart){
        return cartRepository.save(newCart);
    }
}
