package com.kaha.library.service;

import com.kaha.library.exceptions.BadRequestException;
import com.kaha.library.exceptions.SQLCustomException;
import com.kaha.library.model.Authors;
import com.kaha.library.model.BookRequest;
import com.kaha.library.model.Books;
import com.kaha.library.model.ResponseBody;
import com.kaha.library.repository.AuthorDao;
import com.kaha.library.repository.BooksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    @Lazy
    private AuthorDao authorDao;

    @Autowired
    private BooksDao booksDao;

    public ResponseBody<Authors> addAuthor(Authors authors) throws SQLCustomException {
        try {
            ResponseBody<Authors> responseBody = new ResponseBody<>();
            authors.setCreated_date(new Date());
            authors.setLast_modified_date(new Date());
            Authors authors1 = authorDao.save(authors);
            if (authors1 != null){
                responseBody = new ResponseBody<>("OK","Author details are submitted to the database", authors1);
            }else{
                responseBody = new ResponseBody<>("Not Submitted"," Author details are NOT submitted to the database",null);
            }
            return responseBody;
        }catch (Exception e){
            throw new SQLCustomException("Exception while adding author:  " + e.getMessage());
        }

    }


    public ResponseBody<Books> addBooks(BookRequest books) {
        Authors authors = authorDao.findAuthorId(books.getAuthor_id());
        if (authors != null){
            ResponseBody<Books> responseBody = new ResponseBody<>();
            Books book = new Books();
            book.setAuthor_id(authors.getAuthor_id());
            book.setBook_category(books.getBook_category());
            book.setBook_description(books.getBook_description());
            book.setBook_title(books.getBook_title());
            book.setCreated_date(new Date());
            book.setLast_modified_date(new Date());
            book = booksDao.save(book);
            if (book != null){
                responseBody = new ResponseBody<>("OK","Book details are submitted to the database", book);
            }else{
                responseBody = new ResponseBody<>("Not Submitted"," Book details are NOT submitted to the database",null);
            }
            return responseBody;
        }else{
            throw new BadRequestException("Author ID is not present in Authors master table");
        }
    }

    public ResponseBody<List<Books>> getAllBooks(int pageSize, String sort){
        Pageable page = PageRequest.of(0,pageSize, Sort.by(Sort.Direction.DESC,sort));
        Page<Books> result = booksDao.findAll(page);
        ResponseBody<List<Books>> responseBody = new ResponseBody<>();
        if(result.hasContent()) {
            responseBody = new ResponseBody<>("OK","Search is success",result.getContent());
        }else {
            responseBody = new ResponseBody<>("Not Found","No result",result.getContent());
        }
        return responseBody;
    }

    public ResponseBody<List<Books>> searchBooks(String searchBy, String value) {
        List<Books> result = new ArrayList<>();
        ResponseBody<List<Books>> responseBody = new ResponseBody<>();
        if (searchBy.equalsIgnoreCase("author")){
            result = booksDao.searchByAuthor(value);
        }else if (searchBy.equalsIgnoreCase("title")){
            result = booksDao.searchByTitle(value);
        }else if (searchBy.equalsIgnoreCase("category")){
            result = booksDao.searchByCategory(value);
        }else{
            throw new BadRequestException("The field value does not fall under the valid range of (author, title, category");
        }
        if (result.size() > 0){
            responseBody = new ResponseBody<>("OK","Search is success",result);
        }else{
            responseBody = new ResponseBody<>("Not Found","No result",result);
        }
        return responseBody;
    }
}
