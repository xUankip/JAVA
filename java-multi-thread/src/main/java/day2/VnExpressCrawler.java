package day2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class VnExpressCrawler implements MyCrawler{
    Document doc = null;
    @Override
    public ArrayList<String> getLinks(String url) {
        url = "https://vnexpress.net/khoa-hoc";
        try {
            doc = Jsoup.connect(url).get();
            System.out.println(doc.text());
            Elements newsHeadlines = doc.select("article.item-news h3.title-news a");
            for (Element headLine : newsHeadlines){
                System.out.printf("%s \n\t", headLine.absUrl("href"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Article getArticle(String url) {
        try {
            doc = Jsoup.connect(url).get();
            String title = doc.select("h1.title-detail").text();
            String description = doc.select("p.description").text();
            String firstImageLink = doc.select("picture img[itemprop=contentUrl]").attr("data-src");
            String authorName = doc.select("article.fck_detail p.Normal[style=text-align:right;]").text();
            Article article = new Article();
            article.setTitle(title);
            article.setImgDescription(description);
            article.setAuthor(authorName);
            return article;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
