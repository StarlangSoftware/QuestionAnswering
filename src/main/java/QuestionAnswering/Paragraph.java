package QuestionAnswering;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {

    private final String context;
    private List<Question> questionList;

    public Paragraph(String context){
        this.context = context;
        this.questionList = new ArrayList<>();
    }

    public String getContext(){
        return context;
    }

    public Question getQuestion(int index){
        return questionList.get(index);
    }

    public void addQuestion(Question question){
        questionList.add(question);
    }

    public int numberOfQuestions(){
        return questionList.size();
    }
}
