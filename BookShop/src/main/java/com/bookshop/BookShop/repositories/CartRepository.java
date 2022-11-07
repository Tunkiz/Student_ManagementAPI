package com.bookshop.BookShop.repositories;

import com.bookshop.BookShop.models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<ShoppingCart, Long> {
}
