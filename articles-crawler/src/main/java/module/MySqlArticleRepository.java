package module;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MySqlArticleRepository implements ArticleRepository{
    ArrayList<Article> articles = new ArrayList<>();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/article_crawler";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";
    @Override
    public ArrayList<Article> findAll() {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prSql = "select * from human_resource";
            PreparedStatement preparedStatement = connection.prepareStatement(prSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String baseUrl =  resultSet.getString("base_url");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");
                String thumbnail = resultSet.getString("thumbnail");
                String createdAt = resultSet.getString("createdAt");
                String updateAt = resultSet.getString("update_at");
                String deleteAt = resultSet.getString("deleted_at");
                int status = resultSet.getInt("status");
                Article article = new Article();
                article.setId((int) id);
                article.setBaseUrl(baseUrl);
                article.setTitle(title);
                article.setDescription(description);
                article.setContent(content);
                article.setThumbnail(thumbnail);
                article.setCreatedAt(LocalDate.parse(createdAt,dateTimeFormatter));
                article.setUpdatedAt(LocalDate.parse(updateAt,dateTimeFormatter));
                article.setDeletedAt(LocalDate.parse(deleteAt,dateTimeFormatter));
                article.setStatus(status);
                articles.add(article);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }

    @Override
    public Article findByUrl(String url) {
        return null;
    }

    @Override
    public Article save(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = String.format("insert into articles(base_url, title, description, content, thumbnail, createdAt, updated_at, deleted_at, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    article.getBaseUrl(), article.getTitle(), article.getDescription(), article.getContent(), article.getThumbnail(), article.getCreatedAt(), article.getUpdatedAt(), article.getDeletedAt());
            PreparedStatement preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.setString(5, article.getThumbnail());
            preparedStatement.setString(5, article.getCreatedAt().toString());
            preparedStatement.setString(6, article.getUpdatedAt().toString());
            preparedStatement.setString(7, article.getDeletedAt().toString());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return article;
    }

    @Override
    public Article update(Article article) {
        return null;
    }

    @Override
    public void deleteByUrl(String url) {

    }
}
