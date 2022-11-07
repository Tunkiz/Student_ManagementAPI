package com.darkCoders.CodeRe.repositories;

import com.darkCoders.CodeRe.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
