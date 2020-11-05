package com.kaha.library.repository;
import com.kaha.library.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Authors, Integer> {

}
