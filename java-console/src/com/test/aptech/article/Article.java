package com.test.aptech.article;

public class Article {
    private long id;
    private String title;
    private String discus;
    private String avatar;
    private String content;
    private String name;
    private String  time;

    public Article(long id, String title, String discus, String avatar, String content, String name, String time) {
        this.id = id;
        this.title = title;
        this.discus = discus;
        this.avatar = avatar;
        this.content = content;
        this.name = name;
        this.time = time;
    }

    public Article(long id, String title, String discus, String avatar, String content, String name) {
        this.id = id;
        this.title = title;
        this.discus = discus;
        this.avatar = avatar;
        this.content = content;
        this.name = name;
    }

    public Article() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscus() {
        return discus;
    }

    public void setDiscus(String discus) {
        this.discus = discus;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
