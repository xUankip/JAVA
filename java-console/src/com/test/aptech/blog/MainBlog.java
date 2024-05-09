package com.test.aptech.blog;

public class MainBlog {
    public static void main(String[] args) {
        ArticleController articleController = new ArticleController();
        articleController.create();
        articleController.showListArticle();
        articleController.findById();
    }
}
