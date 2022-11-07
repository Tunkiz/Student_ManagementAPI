package com.bookshop.BookShop.models.dto;

import com.bookshop.BookShop.models.Author;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String email;
    private  String address;
//    private List<BookDto> bookDtos = new ArrayList<>();

    public static AuthorDto from(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(authorDto.getName());
        authorDto.setEmail(author.getEmail());
        authorDto.setAddress(author.getAddress());
//        authorDto.setBookDos(author.getBooks().stream().map(BookDto::from).collect(Collectors.toList()));
        return authorDto;
    }
}
