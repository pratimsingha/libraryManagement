package com.kaha.library.repository;
import com.kaha.library.model.Authors;
import com.kaha.library.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDao extends JpaRepository<Books, Integer> {

    @Query("select a from Books a where a.bookTitle like %:title%")
    List<Books> searchByTitle(@Param("title") String title);

    @Query("select a from Books a where a.book_category like %:category%")
    List<Books> searchByCategory(@Param("category") String category);

    @Query("select b from Books b join Authors a on b.author_id = a.author_id where a.author_name like %:name%")
    List<Books> searchByAuthor(@Param("name")String name);

}
