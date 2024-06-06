package day2;

import java.util.ArrayList;

public class MainThread {
    public static void main(String[] args) {
        MyCrawler myCrawler = new VnExpressCrawler();
        ArrayList<String> links = myCrawler.getLinks("https://vnexpress.net/khoa-hoc");
        for (int i = 0; i < links.size(); i++) {
            Article article = myCrawler.getArticle(links.get(i));
            System.out.printf("%d - %s\n", i + 1, article.getTitle());
        }
    }
}