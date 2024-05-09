package com.test.aptech.article;

import java.util.ArrayList;
import java.util.Objects;
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
        System.out.println("List of all Article");
        System.out.println("___________________");
        System.out.printf("%-10s  || %-20s || %-20s|| %-20s|| %-20s  || %-20s \n ", "ID", "Name", "Title", "Discus", "Avatar", "Time");
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            System.out.printf("%-10s || %-20s || %-20s || %-20s || %-20s || %-20s \n ", article.getId(), article.getName(), article.getTitle(), article.getDiscus(), article.getAvatar(), article.getTime());
        }
    }
    public void findById() {
        System.out.println("Type the Article ID");
        long aid = scanner.nextLong();
        scanner.nextLine();
        long index = -1;
        for (int i = 0; i < articles.size(); i++) {
            Article articleId = articles.get(i);
            if (articleId.getId() == aid){
                index = aid;
                System.out.printf("%-10s || %-20s || %-20s || %-20s || %-20s || %-20s \n ", "ID", "Name", "Title", "Discus", "Avatar", "Time");
                System.out.printf("%-10s || %-20s || %-20s || %-20s || %-20s || %-20s ", articleId.getId(), articleId.getName(), articleId.getTitle(), articleId.getDiscus(), articleId.getAvatar(), articleId.getTime());
            }
        }
    }
    public void deleteById() {
        System.out.println("Type the Article you want to Delete");
        long deleteId = scanner.nextLong();
        scanner.nextLine();
        long index = -1;
        for (int i = 0; i < articles.size(); i++) {
            Article delete = articles.get(i);
            if (delete.getId() == deleteId){
                index = deleteId;
                System.out.println("ID found");
                System.out.println("Press Y for delete, Press anything to cancel");
                String choice = scanner.nextLine();
                if (!Objects.equals(choice, "y")){
                    System.out.println("Not delete, Come back to menu");
                } else {
                    articles.remove(i);
                    System.out.println("Delete success");
                }

            }else {
                System.out.println("ID not found");
            }
        }
    }
}
