package com.kaha.library.controller;

import com.kaha.library.exceptions.SQLCustomException;
import com.kaha.library.model.Authors;
import com.kaha.library.model.BookRequest;
import com.kaha.library.model.Books;
import com.kaha.library.model.ResponseBody;
import com.kaha.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBody<Authors> addProduct(@RequestBody Authors authors) throws SQLCustomException {
        try{
            ResponseBody<Authors> authorsResponseBody = libraryService.addAuthor(authors);
            return authorsResponseBody;
        }catch(Exception exception){
            throw new SQLCustomException(exception.getLocalizedMessage());
        }

    }


    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBody<Books> addBook(@RequestBody BookRequest book) throws SQLCustomException {

        try{
            ResponseBody<Books> booksResponseBody = libraryService.addBooks(book);;
            return booksResponseBody;
        }catch(Exception exception){
            throw new SQLCustomException(exception.getLocalizedMessage());
        }
    }

    @GetMapping(value = "/allbooks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBody<List<Books>> addBook(@RequestParam(name = "pageSize") Integer pageSize,
                               @RequestParam(name = "sortBy") String sortBy){

        ResponseBody<List<Books>>  list =  libraryService.getAllBooks(pageSize,sortBy);
        return list;

    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBody<List<Books>> addBook(@RequestParam(name = "field") String searchBy,
                               @RequestParam(name = "value") String value) {

        ResponseBody<List<Books>> list =  libraryService.searchBooks(searchBy, value);
        return list;

    }


}
