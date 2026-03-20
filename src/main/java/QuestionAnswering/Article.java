package QuestionAnswering;

import java.util.ArrayList;
import java.util.List;

public class Article {

    private final String title;
    private List<Paragraph> paragraphs;

    public Article(String title){
        this.title = title;
        this.paragraphs = new ArrayList<>();
    }

    public String getTitle(){
        return title;
    }

    public Paragraph getParagraph(int index){
        return paragraphs.get(index);
    }

    public void addParagraph(Paragraph paragraph){
        paragraphs.add(paragraph);
    }

    public int numberOfParagraphs(){
        return paragraphs.size();
    }

}
