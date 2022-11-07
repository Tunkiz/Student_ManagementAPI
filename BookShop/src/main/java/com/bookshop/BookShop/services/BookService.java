package com.bookshop.BookShop.services;

import com.bookshop.BookShop.models.Book;
import com.bookshop.BookShop.models.exceptions.BookNotFoundException;
import com.bookshop.BookShop.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book getBook(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }
    public Book getByTitle(String title){
        return bookRepository.findByTitle(title);
    }
    public Book getByYear(int year){
        return bookRepository.findByYear(year);
    }
    public List<Book> getBooks(){
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public Book updateBook(Long id, Book book){
        Book bookToUpdate = getBook(id);
        if (Objects.nonNull(book.getTitle())){
            bookToUpdate.setTitle(book.getTitle());
        }
        if (Objects.nonNull(book.getVersion())){
            bookToUpdate.setVersion(book.getVersion());
        }
        if (Objects.nonNull(book.getYear())){
            bookToUpdate.setYear(book.getYear());
        }
        return bookToUpdate;
    }
    public Book deleteBook(Long id){
        Book book = getBook(id);
        bookRepository.delete(book);
        return book;
    }

}
