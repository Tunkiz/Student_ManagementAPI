package com.bookshop.BookShop.models;

import com.bookshop.BookShop.models.dto.AuthorDto;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private  String address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
    public void addBookToAuthor(Book book){
        books.add(book);
    }
    public void removeBookFromAuthor(Book book){
        books.remove(book);
    }
    public static Author from(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setEmail(authorDto.getEmail());
        author.setAddress(authorDto.getAddress());
        return author;
    }
}
