package day2;

import java.util.ArrayList;

public interface MyCrawler {
    //Nhận link tổng, trả về danh sách link con
    ArrayList<String> getLinks(String url);
    //Lấy nội dung chi tiết từ link con
    Article getArticle(String url);

}
