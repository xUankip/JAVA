package module;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //1. Crawl thông tin từ vnexpress.
        //2. Crawl thông tin từ nguồn của tôi.
        //3. Hiển thị danh sách tin hiện có.
        //4. Thoát chương trình.
        ArticlesController articlesController = new ArticlesController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Main Menu");
            System.out.println("_____________________________________");
            System.out.println("1.TienPhong Crawler");
            System.out.println("2.DanTri Crawler");
            System.out.println("3.Articles List");
            System.out.println("4.Exit");
            System.out.println("______________________________________");
            System.out.println("Choose the number form 1-4");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    articlesController.getLinksFromTienPhong();
                    break;
                case 2:
                    articlesController.getLinksFromDanTri();
                    break;
                case 3:
                    articlesController.findAll();
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
