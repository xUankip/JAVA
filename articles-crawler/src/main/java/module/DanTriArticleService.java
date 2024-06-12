package module;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class DanTriArticleService implements ArticleService{
    Document doc = null;
    @Override
    public ArrayList<String> getLinks(String url) {
        HashSet<String> links = new HashSet<>();
        try {
            doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByTag("a");
            for (int i = 0; i < elements.size(); i++) {
                String href = elements.get(i).attr("href");
                if (href.contains("https://dantri.com.vn") && href.contains(".html")){
                    links.add(href);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(links);    }

    @Override
    public Article getArticle(String url) {
        try {
            doc = Jsoup.connect(url).get();
            String title = doc.select("article.singular-container h1.title-page").text();
            String description = doc.select("article.singular-container h2.singular-sapo").text();
            String content = doc.select("div.singular-content p").text();
            String thumbnail = doc.select("figure.image img[alt]").text();
            String createAt = doc.select("time.author-time").text();
            Article article = new Article();
            article.setBaseUrl(url);
            article.setTitle(title);
            article.setDescription(description);
            article.setContent(content);
            article.setThumbnail(thumbnail);
            article.setCreatedAt(createAt);
            return article;
        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }
}
