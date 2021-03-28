package com.abc.monster.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Projects {
    private int pro_id;
    private String pro_img;
    private String pro_title;
    private String pro_present;
    private String pro_content;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date pro_date;
    private int tagid;

    public Projects(Tags tags) {
        this.tags = tags;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    private Tags tags;

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public Projects() {
    }

    public Projects(String pro_img, String pro_title, String pro_present, String pro_content, Date pro_date) {
        this.pro_img = pro_img;
        this.pro_title = pro_title;
        this.pro_present = pro_present;
        this.pro_content = pro_content;
        this.pro_date = pro_date;
    }

    public Projects(int pro_id, String pro_img, String pro_title, String pro_present, String pro_content, Date pro_date) {
        this.pro_id = pro_id;
        this.pro_img = pro_img;
        this.pro_title = pro_title;
        this.pro_present = pro_present;
        this.pro_content = pro_content;
        this.pro_date = pro_date;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_img() {
        return pro_img;
    }

    public void setPro_img(String pro_img) {
        this.pro_img = pro_img;
    }

    public String getPro_title() {
        return pro_title;
    }

    public void setPro_title(String pro_title) {
        this.pro_title = pro_title;
    }

    public String getPro_present() {
        return pro_present;
    }

    public void setPro_present(String pro_present) {
        this.pro_present = pro_present;
    }

    public String getPro_content() {
        return pro_content;
    }

    public void setPro_content(String pro_content) {
        this.pro_content = pro_content;
    }

    public Date getPro_date() {
        return pro_date;
    }

    public void setPro_date(Date pro_date) {
        this.pro_date = pro_date;
    }
}
