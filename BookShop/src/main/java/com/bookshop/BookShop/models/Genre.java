package com.bookshop.BookShop.models;

import com.bookshop.BookShop.models.dto.GenreDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();

    public void addBookToGenre(Book book){
        books.add(book);
    }
    public void removeBookFromGenre(Book book){
        books.remove(book);
    }
    public static Genre from(GenreDto genreDto){
        Genre genre = new Genre();
        genre.setName(genreDto.getName());
        return genre;
    }
}
