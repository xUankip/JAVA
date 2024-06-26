package day2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class VnExpressCrawler implements MyCrawler{
    Document doc = null;
    @Override
    public ArrayList<String> getLinks(String url) {
        HashSet<String> links = new HashSet<>();
        try {
            doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByTag("a");
            for (Element element : elements){
                String href = element.attr("href");
                if (href.contains("vnexpress") && href.contains(".html")){
                    links.add(href);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(links);
    }

    @Override
    public Article getArticle(String url) {
        try {
            doc = Jsoup.connect(url).get();
            String title = doc.select("h1.title-detail").text();
            String description = doc.select("p.description").text();
            String firstImageLink = doc. select ("picture img[itemprop=contentUrl]").attr("data-src");
            String authorName = doc.select("article.fck_detail p.Normal[style=text-align:right;]").text();
            Article article = new Article();
            article.setTitle(title);
            article.setContent(description);
            article.setImgDescription(firstImageLink);
            article.setAuthor(authorName);
            return article;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
