package QuestionAnswering;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Article {

    private final String title;
    private final List<Paragraph> paragraphs;

    @JsonCreator
    public Article(
            @JsonProperty("title") String title,
            @JsonProperty("paragraphs") List<Paragraph> paragraphs
    ){
        this.title = title;
        this.paragraphs = paragraphs;
    }

    public String getTitle(){
        return title;
    }

    public Paragraph getParagraph(int index){
        return paragraphs.get(index);
    }

    public int numberOfParagraphs(){
        return paragraphs == null ? 0 : paragraphs.size();
    }

    public List<Paragraph> getParagraphs(){
        return paragraphs;
    }
}