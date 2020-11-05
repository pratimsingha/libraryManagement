package com.kaha.library.service;

import com.kaha.library.model.Authors;
import com.kaha.library.model.Books;
import com.kaha.library.repository.AuthorDao;
import com.kaha.library.repository.BooksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class LibraryService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BooksDao booksDao;

    public void addAuthor(Authors authors){
        authors.setCreated_date(new Date());
        authors.setLast_modified_date(new Date());
        authorDao.save(authors);
    }


    public void addBooks(Books books){
        books.setCreated_date(new Date());
        books.setLast_modified_date(new Date());

        booksDao.save(books);
    }

}
