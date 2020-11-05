package com.kaha.library.controller;

import com.kaha.library.exceptions.GlobalException;
import com.kaha.library.model.Authors;
import com.kaha.library.model.Books;
import com.kaha.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody Authors authors) throws GlobalException {
        try{
            libraryService.addAuthor(authors);
        }catch(RuntimeException exception){
            throw new GlobalException(exception.getLocalizedMessage());
        }

    }


    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody Books books) throws GlobalException {
        try{
            libraryService.addBooks(books);
        }catch(RuntimeException exception){
            throw new GlobalException(exception.getLocalizedMessage());
        }

    }


}
