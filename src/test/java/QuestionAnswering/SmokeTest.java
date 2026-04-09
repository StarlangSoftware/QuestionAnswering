package QuestionAnswering;

import org.junit.Test;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

public class SmokeTest {

    @Test
    public void canLoadAndQuery() throws Exception {

        InputStream in = getClass().getClassLoader()
                .getResourceAsStream("dataset/en-train-v1.1.json");

        assertNotNull(in);

        DatasetLoader loader = new DatasetLoader();
        Dataset ds = loader.load(in);

        assertNotNull(ds);
        assertFalse(ds.numberOfArticles() == 0);

        Lookup lookup = new Lookup(ds);

        Article art = ds.getArticle(0);
        Paragraph p = art.getParagraph(0);
        Question qa = p.getQuestion(0);

        System.out.println("===== ARTICLE =====");
        System.out.println(art.getTitle());

        System.out.println("\n===== PARAGRAPH =====");
        System.out.println(p.getContext());

        System.out.println("\n===== QUESTION =====");
        System.out.println(qa.getQuestion());

        List<AnswerHit> answers = lookup.getAnswers(qa.getQuestion(), p.getContext());

        assertNotNull(answers);

        System.out.println("\n===== ANSWERS =====");
        for (AnswerHit a : answers) {
            System.out.println("Answer: " + a.getText());
            System.out.println("Start index: " + a.getAnswerStart());
        }
    }
}