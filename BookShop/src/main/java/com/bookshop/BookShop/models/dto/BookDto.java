package com.bookshop.BookShop.models.dto;

import com.bookshop.BookShop.models.Book;
import lombok.Data;

@Data
public class BookDto {
    private  long id;
    private String title;
    private int year;
    private int version;

    public static BookDto from(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(bookDto.getYear());
        bookDto.setVersion(book.getVersion());
        return bookDto;
    }
}
