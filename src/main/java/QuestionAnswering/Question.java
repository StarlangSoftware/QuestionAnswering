package QuestionAnswering;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Question {

    private final String id;
    private final String question;
    private final List<Answer> answers;

    @JsonCreator
    public Question(
            @JsonProperty("id") String id,
            @JsonProperty("question") String question,
            @JsonProperty("answers") List<Answer> answers
    ){
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public String getId(){
        return id;
    }

    public String getQuestion(){
        return question;
    }

    public Answer getAnswer(int index){
        return answers.get(index);
    }

    public int numberOfAnswers(){
        return answers == null ? 0 : answers.size();
    }

    public List<Answer> getAnswers(){
        return answers;
    }
}
