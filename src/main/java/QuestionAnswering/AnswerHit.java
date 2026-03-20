package QuestionAnswering;

public class AnswerHit {

    private final String id;
    private final String text;
    private final int answerStart;

    public AnswerHit(String id, String text, int answerStart) {
        this.id = id;
        this.text = text;
        this.answerStart = answerStart;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getAnswerStart() {
        return answerStart;
    }
}
