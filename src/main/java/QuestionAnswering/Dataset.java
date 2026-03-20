package QuestionAnswering;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

    private final String version;
    private List<Article> data;

    public Dataset(String version){
        this.version = version;
        data = new ArrayList<>();
    }

    public String getVersion(){
        return version;
    }

    public int numberOfArticles(){
        return data.size();
    }

    public Article getArticle(int index){
        return data.get(index);
    }

    public void addArticle(Article article){
        data.add(article);
    }
}
