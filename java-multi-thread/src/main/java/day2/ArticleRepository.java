package day2;

import java.util.ArrayList;

public interface ArticleRepository {
    ArrayList<Article> findAll();
    Article findByUrl();
    Article save(Article article);
    Article update(Article article);
    void  deleteByUrl(String url);
}
