package com.bookshop.BookShop.services;

import com.bookshop.BookShop.models.Author;
import com.bookshop.BookShop.models.exceptions.AuthorNotFoundException;
import com.bookshop.BookShop.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }
    public Author getAuthor(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
    }
    public Author getAuthorByName(String name){
        return authorRepository.findByName(name);
    }
    public List<Author> getAuthors(){
        return StreamSupport.stream(authorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public Author updateAuthor(Long id, Author author){
        Author authorToUpdate = getAuthor(id);
        if (Objects.nonNull(author.getName())){
            authorToUpdate.setName(author.getName());
        }
        if (Objects.nonNull(author.getEmail())){
            authorToUpdate.setEmail(author.getEmail());
        }
        if (Objects.nonNull(author.getAddress())){
            authorToUpdate.setAddress(author.getAddress());
        }
        return authorToUpdate;
    }
    public Author deleteAuthor(Long id){
        Author author = getAuthor(id);
        authorRepository.delete(author);
        return author;
    }
}
