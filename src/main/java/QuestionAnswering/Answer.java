package QuestionAnswering;

public class Answer {

    private final String text;
    private final int answerStart;

    public Answer(String text, int answerStart){
        this.text = text;
        this.answerStart = answerStart;
    }

    public String getText(){
        return text;
    }

    public int getAnswerStart(){
        return answerStart;
    }
}
