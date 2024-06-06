package day2;

import java.util.ArrayList;

public class MySqlRepositoryImp implements ArticleRepository{
    VnExpressCrawler vnExpressCrawler = new VnExpressCrawler();
    @Override
    public ArrayList<Article> findAll() {
        String url = "https://vnexpress.net/khoa-hoc";
        vnExpressCrawler.getLinks(url);
        return null;
    }

    @Override
    public Article findByUrl() {
        String url = "https://vnexpress.net/tham-hoa-xay-ra-khi-bo-nuoc-da-vao-dau-soi-4754005.html ";
        vnExpressCrawler.getArticle(url);
        return null;
    }

    @Override
    public Article save(Article article) {
        return null;
    }

    @Override
    public Article update(Article article) {
        return null;
    }

    @Override
    public void deleteByUrl(String url) {

    }
}
