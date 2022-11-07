package com.bookshop.BookShop.Controllers;

import com.bookshop.BookShop.Models.DTOs.OrderDTO;
import com.bookshop.BookShop.Models.DTOs.UpdateOrderDTO;
import com.bookshop.BookShop.Services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "api/v1/")
@AllArgsConstructor
public class CartServiceController {
    private final CartService cartService;

    @PostMapping(value = "add")
    public ResponseEntity<String> addProduct(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<String>(cartService.addToCart(orderDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "orders")
    public ResponseEntity<HashMap<String, Object>> getOrders(){
        return new ResponseEntity<>(cartService.getProducts(), HttpStatus.OK);
    }

    @PutMapping(value = "order")
    public ResponseEntity<String> updateOrder(@RequestBody UpdateOrderDTO updateOrderDTO){
        return new ResponseEntity<>(cartService.updateOrder( updateOrderDTO ), HttpStatus.CREATED);
    }

    @DeleteMapping( value = "order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id){
        return new ResponseEntity<>(cartService.deleteOrder(id), HttpStatus.OK);
    }
}
