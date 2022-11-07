package com.bookshop.BookShop.Repositories;

import com.bookshop.BookShop.Models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<ShoppingCart, Long> {
    public Optional<ShoppingCart> findByUserId(String user_email);
}
