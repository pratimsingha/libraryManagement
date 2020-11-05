package com.kaha.library.service;

import com.kaha.library.exceptions.GlobalException;
import com.kaha.library.model.Authors;
import com.kaha.library.model.BookRequest;
import com.kaha.library.model.Books;
import com.kaha.library.repository.AuthorDao;
import com.kaha.library.repository.BooksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class LibraryService {

    @Autowired
    @Lazy
    private AuthorDao authorDao;

    @Autowired
    private BooksDao booksDao;

    public void addAuthor(Authors authors){
        authors.setCreated_date(new Date());
        authors.setLast_modified_date(new Date());
        authorDao.save(authors);
    }


    public void addBooks(BookRequest books) throws GlobalException{
        Authors authors = authorDao.findAuthorId(books.getAuthor_id());
        if (authors != null){
            Books book = new Books();
            book.setAuthor_id(authors.getAuthor_id());
            book.setBook_category(books.getBook_category());
            book.setBook_description(books.getBook_description());
            book.setBook_title(books.getBook_title());
            book.setCreated_date(new Date());
            book.setLast_modified_date(new Date());
            booksDao.save(book);
        }else{
            throw new GlobalException("Author ID is not present in Authors master table");
        }

    }

}
