package module;

import java.util.ArrayList;

public class ArticlesController {
    public void getLinksFromVnExpress() {
//        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
//        ArrayList<String> getLinks = articleService.getLinks(url);
//        for (int i = 0; i < getLinks.size(); i++) {
//            Article article = articleService.getArticle(getLinks.get(i));
//            System.out.printf("%d. %s\n", i + 1, article.getTitle());
//            mySqlArticleRepository.save(article);
//        }

        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        ArticleService articleService = new VnexpressArticleService();
        ArrayList<String> linksList = articleService.getLinks("https://vnexpress.net/khoa-hoc");
        for (int i = 0; i < linksList.size(); i++) {
            Article article = articleService.getArticle(linksList.get(i));
            System.out.printf("%d .%s\n", i + 1, article.getTitle());
            mySqlArticleRepository.save(article);
        }
    }

    public void getLinksFromDanTri() {
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        ArticleService articleService = new DanTriArticleService();
        ArrayList<String> linksList = articleService.getLinks("https://dantri.com.vn/o-to-xe-may.htm");
        for (int i = 0; i < linksList.size(); i++) {
            Article article = articleService.getArticle(linksList.get(i));
            System.out.printf("%d .%s\n", i + 1, article.getTitle());
            mySqlArticleRepository.save(article);
        }
    }
}

