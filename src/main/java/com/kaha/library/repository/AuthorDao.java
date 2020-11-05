package com.kaha.library.repository;
import com.kaha.library.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Authors, Integer> {

    @Query("select a from Authors a where a.author_id = :author_id")
    Authors findAuthorId(@Param("author_id") Integer author_id);
}
