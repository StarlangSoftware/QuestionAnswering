package QuestionAnswering;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Paragraph {

    private final String context;
    private final List<Question> questionList;

    @JsonCreator
    public Paragraph(
            @JsonProperty("context") String context,
            @JsonProperty("qas") List<Question> questionList
    ){
        this.context = context;
        this.questionList = questionList;
    }

    public String getContext(){
        return context;
    }

    public Question getQuestion(int index){
        return questionList.get(index);
    }

    public int numberOfQuestions(){
        return questionList == null ? 0 : questionList.size();
    }

    public List<Question> getQuestionList(){
        return questionList;
    }
}