package module;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //1. Crawl thông tin từ vnexpress.
        //2. Crawl thông tin từ nguồn của tôi.
        //3. Hiển thị danh sách tin hiện có.
        //4. Thoát chương trình.
        ArticleService articleService = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Main Menu");
            System.out.println("_____________________________________");
            System.out.println("1.VnExpress Crawler");
            System.out.println("2.DanTri Crawler");
            System.out.println("3.Articles List");
            System.out.println("4.Exit");
            System.out.println("______________________________________");
            System.out.println("Choose the number form 1-4");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    articleService = new VnexpressArticleService();
                    ArrayList<String> links = articleService.getLinks("https://vnexpress.net/khoa-hoc");
                    for (int i = 0; i < links.size(); i++) {
                        Article article = articleService.getArticle(links.get(i));
                        System.out.printf("%d - %s\n", i + 1, article.getTitle());
                    }
                    break;
                case 2:
                    articleService = new DanTriArticleService();
                    break;
                case 3:
                    //find All
                    break;
                case 4:
                    System.out.println("Closing Program");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
