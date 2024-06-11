package module;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MySqlArticleRepository implements ArticleRepository {
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/article_crawler";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public ArrayList<Article> findAll() {
        ArrayList articles = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prSql = "select * from articles";
            PreparedStatement preparedStatement = connection.prepareStatement(prSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String baseUrl = resultSet.getString("base_url");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");
                String thumbnail = resultSet.getString("thumbnail");
                String createdAt = resultSet.getString("createdAt");
                String updateAt = resultSet.getString("updated_at");
                String deleteAt = resultSet.getString("deleted_at");
                int status = resultSet.getInt("status");
                Article article = new Article();
                article.setId(id);
                article.setBaseUrl(baseUrl);
                article.setTitle(title);
                article.setDescription(description);
                article.setContent(content);
                article.setThumbnail(thumbnail);
                article.setCreatedAt(createdAt);
                article.setUpdatedAt(LocalDate.parse(updateAt, dateTimeFormatter));
                article.setDeletedAt(LocalDate.parse(deleteAt, dateTimeFormatter));
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
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String sql = "select * from articles where base_url = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, url);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String baseUrl = resultSet.getString("base_url");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");
                String thumbnail = resultSet.getString("thumbnail");
                String createdAt = resultSet.getString("createdAt");
                String updateAt = resultSet.getString("updated_at");
                String deleteAt = resultSet.getString("deleted_at");
                int status = resultSet.getInt("status");
                Article article = new Article();
                article.setBaseUrl(baseUrl);
                article.setTitle(title);
                article.setDescription(description);
                article.setContent(content);
                article.setThumbnail(thumbnail);
                article.setCreatedAt(createdAt);
                article.setUpdatedAt(LocalDate.parse(updateAt, dateTimeFormatter));
                article.setDeletedAt(LocalDate.parse(deleteAt, dateTimeFormatter));
                article.setStatus(status);
            }
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return null;
    }

    @Override
    public Article save(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = "insert into articles (base_url, title, description, content, thumbnail, createdAt, status) values (?, ?, ?, ?, ?, ?, 1)";
            PreparedStatement preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.setString(5, article.getThumbnail());
            preparedStatement.setString(6, article.getCreatedAt());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article update(Article article) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = "update articles set title = ?, description = ?, content = ?, thumbnail = ?, createAt = ?, updated_at = ? where url = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getDescription());
            preparedStatement.setString(3, article.getContent());
            preparedStatement.setString(4, article.getThumbnail());
            preparedStatement.setString(5, article.getCreatedAt());
            preparedStatement.setString(6, article.getUpdatedAt().toString());
            preparedStatement.setString(7, article.getBaseUrl());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
        System.out.println("Update success");
        return article;
    }

    @Override
    public void deleteByUrl(String url) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            Article article = new Article();
            String prSql = "update articles set status = -1, deleted_at = ? where url = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(prSql);
            preparedStatement.setString(1, article.getDeletedAt().toString());
            preparedStatement.setString(2, article.getBaseUrl());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
        System.out.println("Delete success");
    }
}
