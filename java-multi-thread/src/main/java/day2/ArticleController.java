package day2;

public class ArticleController {
    MySqlRepositoryImp mySqlRepositoryImp = new MySqlRepositoryImp();
    public void findAll(){
        mySqlRepositoryImp.findAll();
    }
    public void findByUrl(){
        mySqlRepositoryImp.findByUrl();
    }

}
