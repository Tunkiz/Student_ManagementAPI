package com.bookshop.BookShop.models.dto;

import com.bookshop.BookShop.models.Book;
import com.bookshop.BookShop.models.Genre;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GenreDto {
    private Long id;
    private String name;
    //List<BookDto> bookDtos = new ArrayList<>();

    public static GenreDto from(Genre genre){
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        return genreDto;
    }
}
