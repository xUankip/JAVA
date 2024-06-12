package module;

import java.util.ArrayList;

public class ArticlesController {
    public void getLinksFromTienPhong() {
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        ArticleService articleService = new TienPhongArticleService();
        ArrayList<String> linksList = articleService.getLinks("https://tienphong.vn/the-thao/");
        for (int i = 0; i < linksList.size(); i++) {
            Article article = articleService.getArticle(linksList.get(i));
            System.out.printf("%d .%s\n", i + 1, article.getTitle());
            mySqlArticleRepository.save(article);
        }
    }

    public void getLinksFromDanTri() {
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        ArticleService articleService = new DanTriArticleService();
        ArrayList<String> linksList = articleService.getLinks("https://dantri.com.vn/suc-khoe.htm");
        for (int i = 0; i < linksList.size(); i++) {
            Article article = articleService.getArticle(linksList.get(i));
            System.out.printf("%d .%s\n", i + 1, article.getTitle());
            mySqlArticleRepository.save(article);
        }
    }
    public void findAll(){
        MySqlArticleRepository mySqlArticleRepository = new MySqlArticleRepository();
        ArrayList<Article> articleList = mySqlArticleRepository.findAll();
        for (Article article : articleList){
            System.out.println("Title" + article.getTitle());
        }
    }
}

