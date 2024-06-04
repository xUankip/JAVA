package day2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;

public class VnExpressCrawler implements MyCrawler{
    @Override
    public ArrayList<String> getLinks(String url) {
        return null;
    }

    @Override
    public Article getArticle(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://dantri.com.vn/xa-hoi/bo-cong-an-trien-khai-phan-mem-quan-ly-tang-ni-phat-tu-20240603161703774.htm").get();
            System.out.println((doc.title()));
            System.out.println((doc.select("div.singular-wrap article.singular-container h1.title-page detail")));
            System.out.println(doc.select("div.author-name b").text());
            System.out.println(doc.select("time.author-time").text());
            System.out.println(doc.select("figure.image img").attr("data-src"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
