package com.bookshop.BookShop.repositories;

import com.bookshop.BookShop.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    public Genre findByName(String name);
}
