package com.bookshop.BookShop.repositories;

import com.bookshop.BookShop.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    public Author findByName(String name);
}
