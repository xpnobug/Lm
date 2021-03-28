package com.abc.monster.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Article {
    private int a_id;
    private String title;
    private String present;
    private String content;
    private int channer;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date cdate;

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Article() {
    }

    public int getChanner() {
        return channer;
    }

    public void setChanner(int channer) {
        this.channer = channer;
    }

    public Article(String title, String present, String content, int channer, Date cdate) {
        this.title = title;
        this.present = present;
        this.content = content;
        this.channer = channer;
        this.cdate = cdate;
    }

    public Article(int a_id, String title, String present, String content, int channer, Date cdate) {
        this.a_id = a_id;
        this.title = title;
        this.present = present;
        this.content = content;
        this.channer = channer;
        this.cdate = cdate;
    }

    public Article(String title, String present, String content, int channer, Date cdate, Channel channel) {
        this.title = title;
        this.present = present;
        this.content = content;
        this.channer = channer;
        this.cdate = cdate;
        this.channel = channel;
    }

    public Article(int a_id, String title, String present, String content, Date cdate) {
        this.a_id = a_id;
        this.title = title;
        this.present = present;
        this.content = content;
        this.cdate = cdate;
    }

    public Article(String title, String present, String content, Date cdate) {
        this.title = title;
        this.present = present;
        this.content = content;
        this.cdate = cdate;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
