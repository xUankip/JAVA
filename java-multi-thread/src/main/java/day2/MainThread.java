package day2;

import java.util.ArrayList;

public class MainThread {
    public static void main(String[] args) {
        VnExpressCrawler vnExpressCrawler = new VnExpressCrawler();
        ArrayList<String> list = new ArrayList<>();
        ArticleController articleController = new ArticleController();
        vnExpressCrawler.getLinks("https://vnexpress.net");
    }
}