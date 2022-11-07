package com.bookshop.BookShop.services;

import com.bookshop.BookShop.models.Book;
import com.bookshop.BookShop.models.OrderItem;
import com.bookshop.BookShop.models.ShoppingCart;
import com.bookshop.BookShop.models.exceptions.BookNotFoundException;
import com.bookshop.BookShop.models.exceptions.CartNotFoundException;
import com.bookshop.BookShop.repositories.OrderRepository;
import com.bookshop.BookShop.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final OrderItem orderItem;
    public ShoppingCart addCart(ShoppingCart cart){
        return cartRepository.save(cart);
    }
    public ShoppingCart getCart(Long id){
        return cartRepository.findById(id).orElseThrow(()-> new CartNotFoundException(id));
    }
    public ShoppingCart addOrderToCart(
            String title, 
            Long cartId,
            String userId,
            int quantity){
        Book book = bookService.getByTitle(title);
        orderItem.setBook(book);
        orderItem.setQuantity(quantity);
        ShoppingCart cart = cartRepository.findById(cartId).orElseThrow();
        cart.setUserId(userId);
        orderItem.setCart(cart);
        cart.addBook(orderItem);
        return cart;
    }
    public ShoppingCart deleteOrderFromCart(
            String title,
            Long cartId,
            String userId,
            int quantity){
        Book book = bookService.getByTitle(title);
        orderItem.setBook(null);
        orderItem.setQuantity(0);
        ShoppingCart cart = cartRepository.findById(cartId).orElseThrow();
        cart.setUserId(null);
        orderItem.setCart(cart);
        cart.deleteBook(orderItem);
        return cart;
    }
//    public ShoppingCart updateOrderFromCart(Long cartId, Long orderId, int quantity){
//        ShoppingCart cart = cartRepository.findById(cartId).orElseThrow();
//        OrderItem orderItem1 = orderRepository.findById(orderId).orElseThrow();
//        cart.get
//        orderItem1.setQuantity(quantity);
//        return cart
//
//
//    }
    
    

}
