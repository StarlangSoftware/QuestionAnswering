package QuestionAnswering;

import java.util.*;

public class Lookup {

    private final Map<String, List<AnswerHit>> byQuestionAndContext = new HashMap<>();
    private final Map<String, List<AnswerHit>> byId = new HashMap<>();

    public Lookup(Dataset dataset) {
        if (dataset == null || dataset.numberOfArticles() == 0) return;

        for (int i = 0; i < dataset.numberOfArticles(); i++) {
            Article article = dataset.getArticle(i);
            if (article.numberOfParagraphs() == 0) continue;

            for (int j = 0; j < article.numberOfParagraphs(); j++) {
                Paragraph paragraph = article.getParagraph(j);
                String context = paragraph.getContext();
                if (paragraph.numberOfQuestions() == 0) continue;

                for (int k = 0; k < paragraph.numberOfQuestions(); k++) {
                    Question qa = paragraph.getQuestion(k);
                    List<AnswerHit> hits = new ArrayList<>();
                    if (qa.numberOfAnswers() != 0) {
                        for (int m = 0; m < qa.numberOfAnswers(); m++) {
                            Answer ans = qa.getAnswer(m);
                            hits.add(new AnswerHit(qa.getId(), ans.getText(), ans.getAnswerStart()));
                        }
                    }

                    // index by id
                    byId.put(qa.getId(), hits);

                    // index by exact question+context (normalized)
                    String key = key(qa.getQuestion(), context);
                    byQuestionAndContext.computeIfAbsent(key, l -> new ArrayList<>()).addAll(hits);
                }
            }
        }
    }

    public List<AnswerHit> getAnswers(String question, String context) {
        return byQuestionAndContext.getOrDefault(key(question, context), null);
    }

    public List<AnswerHit> getAnswersById(String id) {
        return byId.getOrDefault(id, null);
    }

    private static String key(String question, String context) {
        return normalize(question) + "||" + normalize(context);
    }

    private static String normalize(String s) {
        if (s == null) return "";
        return s.trim().replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
    }
}
