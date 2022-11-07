package com.darkCoders.CodeRe.models;

import com.darkCoders.CodeRe.models.dtos.ProductDTO;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;
    public static Product from(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setCart(productDTO.getCart());
        return product;
    }
}
