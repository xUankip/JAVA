package com.test.aptech.article;

import java.util.Scanner;

public class MainArticle {
    public static void main(String[] args) {
        ArticleController articleController = new ArticleController();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Article Menu");
            System.out.println("---------------------------");
            System.out.println("1. Create an Article");
            System.out.println("2. Find an Article");
            System.out.println("3. Delete an Article by ID");
            System.out.println("4. Show All Articles");
            System.out.println("5. Quit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    articleController.create();
                    break;
                case 2:
                    articleController.findById();
                    break;
                case 3:
                    articleController.deleteById();
                    break;
                case 4:
                    articleController.showListArticle();
                    break;
                case 5:
                    System.out.println("Program Close");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice try again");
                    break;
            }
        }
    }
}
