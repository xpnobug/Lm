package com.abc.monster.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Comment {
    private int id;
    private String author;
    private String comment;
    private String email;
    private String url;
    private String img;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date cdate;

    public Comment() {
    }

    public Comment(String author, String comment, String email, String url, String img, Date cdate) {
        this.author = author;
        this.comment = comment;
        this.email = email;
        this.url = url;
        this.img = img;
        this.cdate = cdate;
    }

    public Comment(int id, String author, String comment, String email, String url, String img, Date cdate) {
        this.id = id;
        this.author = author;
        this.comment = comment;
        this.email = email;
        this.url = url;
        this.img = img;
        this.cdate = cdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
