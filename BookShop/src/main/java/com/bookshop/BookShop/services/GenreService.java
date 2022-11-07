package com.bookshop.BookShop.services;

import com.bookshop.BookShop.models.Genre;
import com.bookshop.BookShop.models.exceptions.GenreNotFoundException;
import com.bookshop.BookShop.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }
    public Genre getGenre(Long id){
         return genreRepository.findById(id).orElseThrow(() -> new GenreNotFoundException(id));
    }
    public List<Genre> getGenres(){
        return StreamSupport.stream(genreRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    public Genre updateGenre(Long id, Genre genre){
        Genre genreToUpdate = getGenre(id);
        if (Objects.nonNull(genre.getName())){
            genreToUpdate.setName(genre.getName());
        }
        return genreToUpdate;
    }
    public Genre deleteGenre(Long id){
        Genre genre = getGenre(id);
        genreRepository.delete(genre);
        return genre;
    }
}
