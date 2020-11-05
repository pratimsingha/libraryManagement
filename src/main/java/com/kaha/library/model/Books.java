package com.kaha.library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer book_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Authors author_id;
//    @Column(name = "author_id", nullable = false)
//    private Integer author_id;
    @Column(name = "book_title", nullable = false)
    private String book_title;
    @Column(name = "book_description", nullable = false)
    private String book_description;
    @Column(name = "book_category", nullable = false)
    private String book_category;
    @Column(name = "created_date", nullable = false)
    private Date created_date;
    @Column(name = "last_modified_date", nullable = false)
    private Date last_modified_date;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Authors getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Authors author_id) {
        this.author_id = author_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_description() {
        return book_description;
    }

    public void setBook_description(String book_description) {
        this.book_description = book_description;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }
}
