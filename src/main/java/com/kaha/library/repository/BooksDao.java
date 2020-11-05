package com.kaha.library.repository;
import com.kaha.library.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksDao extends JpaRepository<Books, Integer> {

}
