package com.abc.monster.pojo;

public class Channel {
    private int id;
    private String name;
    private int status;

    public Channel() {
    }

    public Channel(int id, String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Channel(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
