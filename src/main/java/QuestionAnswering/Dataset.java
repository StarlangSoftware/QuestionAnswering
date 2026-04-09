package QuestionAnswering;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dataset {

    private final String version;
    private final List<Article> data;

    @JsonCreator
    public Dataset(
            @JsonProperty("version") String version,
            @JsonProperty("data") List<Article> data
    ){
        this.version = version;
        this.data = data;
    }

    public String getVersion(){
        return version;
    }

    public int numberOfArticles(){
        return data == null ? 0 : data.size();
    }

    public Article getArticle(int index){
        return data.get(index);
    }

    public List<Article> getData(){
        return data;
    }
}