package module;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class VnexpressArticleService implements ArticleService{
    Document doc = null;
    @Override
    public ArrayList<String> getLinks(String url) {
        HashSet<String> links = new HashSet<>();
        try {
            doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByTag("a");
            for (int i = 0; i < elements.size(); i++) {
                String href = elements.get(i).attr("href");
                if (href.contains("vnexpress") && href.contains(".html")){
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
            String title = doc.select("h1.title-detail").text();
            String description = doc.select("p.description").text();
            String content = doc.select("article.fck_detail p.Normal").text();
            String thumbnail = doc.select("div.fig-picture  img[itemprop=contentUrl]").attr("data-src");
            String createAt = doc.select("span.date ").text();
            Article article = new Article();
            article.setBaseUrl(url);
            article.setTitle(title);
            article.setDescription(description);
            article.setContent(content);
            article.setThumbnail(thumbnail);
            article.setCreatedAt(createAt);
            article.setUpdatedAt(LocalDate.now());
            article.setDeletedAt(LocalDate.now());
            article.setStatus(1);
            return article;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
