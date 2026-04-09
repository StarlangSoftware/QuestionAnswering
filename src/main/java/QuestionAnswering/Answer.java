package QuestionAnswering;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    private final String text;

    @JsonProperty("answer_start")
    private final int answerStart;

    @JsonCreator
    public Answer(
            @JsonProperty("text") String text,
            @JsonProperty("answer_start") int answerStart
    ) {
        this.text = text;
        this.answerStart = answerStart;
    }

    public String getText() {
        return text; }

    public int getAnswerStart() {
        return answerStart; }
}

