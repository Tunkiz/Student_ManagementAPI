package com.bookshop.BookShop.repositories;

import com.bookshop.BookShop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findByTitle(String title);
    public Book findByYear(int year);
}
