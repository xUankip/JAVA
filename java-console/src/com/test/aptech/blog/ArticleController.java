package com.test.aptech.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ArticleController {
    ArrayList<Article> articles = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void create() {
        System.out.println("Type the information below:");
        System.out.println("ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Discus: ");
        String discus = scanner.nextLine();
        System.out.println("Content: ");
        String content = scanner.nextLine();
        System.out.println("Avatar: ");
        String avatar = scanner.nextLine();
        System.out.println("Time: ");
        String time = scanner.nextLine();
        Article article = new Article();
        article.setId(id);
        article.setName(name);
        article.setTitle(title);
        article.setDiscus(discus);
        article.setContent(content);
        article.setAvatar(avatar);
        article.setTime(time);
        System.out.printf("ID: %d \n", id);
        System.out.printf("Name: %s \n", name);
        System.out.printf("Title: %s \n", title);
        System.out.printf("Discus: %s \n", discus);
        System.out.printf("Content: %s \n", content);
        System.out.printf("Avatar: %s \n", avatar);
        System.out.printf("Time: %s \n", time);
        articles.add(article);
    }
    public void showListArticle() {
        for (int i = 0; i < articles.size(); i++) {
            System.out.println("List of all Article");
            System.out.println("___________________");
            System.out.printf("%-10s || %-20s || %-20s || %-20s || %-20s || %-20s \n ", "ID", "Name", "Title", "Discus", "Avatar", "Time");
            Article article = articles.get(i);
            System.out.printf("%-10s || %-20s || %-20s || %-20s || %-20s || %-20s ", article.getId(), article.getName(), article.getTitle(), article.getDiscus(), article.getAvatar(), article.getTime());
        }
    }
    public void findById() {
        System.out.println("Type the Article ID");
        long aID = scanner.nextLong();
        scanner.nextLine();
        long index = -1;
        for (int i = 0; i < articles.size(); i++) {
            Article articleId = articles.get(i);
            if (articleId.getId() == aID){
                index = aID;
                System.out.printf("%-10s || %-20s || %-20s || %-20s || %-20s || %-20s \n ", "ID", "Name", "Title", "Discus", "Avatar", "Time");
                System.out.printf("%-10s || %-20s || %-20s || %-20s || %-20s || %-20s ", articleId.getId(), articleId.getName(), articleId.getTitle(), articleId.getDiscus(), articleId.getAvatar(), articleId.getTime());
            }
        }
    }
    public void deleteById() {

    }

}
