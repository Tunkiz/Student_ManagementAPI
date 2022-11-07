package com.bookshop.BookShop.Controllers;

import com.bookshop.BookShop.Models.Product;
import com.bookshop.BookShop.Services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/product/")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody final Product product){
        productService.addProduct(product);
        return "New Product added";
    }
    @GetMapping(value ="get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable final Long id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @GetMapping(value = "{dress}")
    public HashMap<String, Object> getProductByDressTypeOnSearch(@PathVariable final String dress){
        HashMap<String, Object> hs = new HashMap<>();
        List<Product> products = productService.getProductsByDressType(dress);
        hs.put("products", products);
        hs.put("length", products.size());
        return hs;
    }
    @GetMapping(value = "clothes")
    public HashMap<String, Object> getProductsBySexAndSession(
            @RequestParam(name = "sex") String sex,
            @RequestParam(defaultValue = "10") Integer items,
            @RequestParam(defaultValue = "0") Integer page,
            HttpServletRequest request){

        List<String> messages = (List<String>) request.getSession().getAttribute("SESSION_STORE");

        if (messages == null){
            messages = new ArrayList<>();
        }

        Map<Boolean, Long> countByType = messages.stream().collect(Collectors.partitioningBy(
                (String msg) -> (msg.equals("O")),
                Collectors.counting()));

        return productService.getProductsBySex(sex, items, page, countByType);
    }
}
