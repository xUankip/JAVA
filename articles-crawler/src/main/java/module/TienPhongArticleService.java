package module;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class TienPhongArticleService implements ArticleService{
    Document doc = null;
    @Override
    public ArrayList<String> getLinks(String url) {
        HashSet<String> links = new HashSet<>();
        try {
            doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByTag("a");
            for (int i = 0; i < elements.size(); i++) {
                String href = elements.get(i).attr("href");
                if (href.contains("https://tienphong") && href.contains(".tpo")){
                    links.add(href);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(links);
    }

    @Override
    public Article getArticle(String url) {
        try {
            doc = Jsoup.connect(url).get();
            String title = doc.select("h1.article__title").text();
            String description = doc.select("div.article__sapo").text();
            String content = doc.select("div.article__body p").text();
            String thumbnail = doc.select("div.article__body img").attr("data-src");
            String createAt = doc.select("time").text();
            Article article = new Article();
            article.setBaseUrl(url);
            article.setTitle(title);
            article.setDescription(description);
            article.setContent(content);
            article.setThumbnail(thumbnail);
            article.setCreatedAt(createAt);
            return article;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
