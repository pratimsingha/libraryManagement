package com.kaha.library.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Integer author_id;
    @Column(name = "author_name", nullable = false)
    private String author_name;
    @Column(name = "author_description", nullable = false)
    private String author_description;
    @Column(name = "created_date", nullable = false)
    private Date created_date;
    @Column(name = "last_modified_date", nullable = false)
    private Date last_modified_date;

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_description() {
        return author_description;
    }

    public void setAuthor_description(String author_description) {
        this.author_description = author_description;
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
