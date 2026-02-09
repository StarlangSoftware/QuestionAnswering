package QuestionAnswering;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class SmokeTest {

    @Test
    void canLoadAndQuery() throws Exception {

        InputStream in = getClass().getClassLoader()
                .getResourceAsStream("dataset/en-train-v1.1.json");

        assertNotNull(in, "Resource not found! Put the file under src/test/resources/dataset/");

        DatasetLoader loader = new DatasetLoader();
        Dataset ds = loader.load(in);

        assertNotNull(ds);

        Lookup lookup = new Lookup(ds);

        Article art = ds.data.get(0);
        Paragraph p = art.paragraphs.get(0);
        Question qa = p.qas.get(0);

        System.out.println("===== ARTICLE =====");
        System.out.println(art.title);

        System.out.println("\n===== PARAGRAPH =====");
        System.out.println(p.context);

        System.out.println("\n===== QUESTION =====");
        System.out.println(qa.question);

        var answers = lookup.getAnswers(qa.question, p.context);

        System.out.println("\n===== ANSWERS =====");
        for (Lookup.AnswerHit a : answers) {
            System.out.println("Answer: " + a.text);
            System.out.println("Start index: " + a.answerStart);
        }
    }
}
