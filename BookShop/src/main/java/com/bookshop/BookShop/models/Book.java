package com.bookshop.BookShop.models;

import com.bookshop.BookShop.models.dto.BookDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String title;
    private int year;
    private int version;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Genre genre;
    @ManyToOne
    private ShoppingCart cart;
    public static Book from(BookDto bookDto){
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setVersion(bookDto.getVersion());
        return book;
    }

}
