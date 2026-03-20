package QuestionAnswering;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private final String id;
    private final String question;
    private List<Answer> answers;

    public Question(String id, String question){
        this.id = id;
        this.question = question;
        answers = new ArrayList<Answer>();
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

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public int numberOfAnswers(){
        return answers.size();
    }
}
