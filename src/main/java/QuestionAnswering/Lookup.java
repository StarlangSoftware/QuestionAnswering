package QuestionAnswering;

import java.util.*;

public class Lookup {

    public static class AnswerHit {
        public final String id;
        public final String text;
        public final int answerStart;

        public AnswerHit(String id, String text, int answerStart) {
            this.id = id;
            this.text = text;
            this.answerStart = answerStart;
        }
    }


    private final Map<String, List<AnswerHit>> byQuestionAndContext = new HashMap<>();
    private final Map<String, List<AnswerHit>> byId = new HashMap<>();

    public Lookup(Dataset dataset) {
        if (dataset == null || dataset.data == null) return;

        for (Article article : dataset.data) {
            if (article.paragraphs == null) continue;

            for (Paragraph paragraph : article.paragraphs) {
                String context = paragraph.context;
                if (paragraph.qas == null) continue;

                for (Question qa : paragraph.qas) {
                    List<AnswerHit> hits = new ArrayList<>();
                    if (qa.answers != null) {
                        for (Answer ans : qa.answers) {
                            hits.add(new AnswerHit(qa.id, ans.text, ans.answer_start));
                        }
                    }

                    // index by id
                    byId.put(qa.id, hits);

                    // index by exact question+context (normalized)
                    String key = key(qa.question, context);
                    byQuestionAndContext.computeIfAbsent(key, k -> new ArrayList<>()).addAll(hits);
                }
            }
        }
    }

    public List<AnswerHit> getAnswers(String question, String context) {
        return byQuestionAndContext.getOrDefault(key(question, context), List.of());
    }

    public List<AnswerHit> getAnswersById(String id) {
        return byId.getOrDefault(id, List.of());
    }

    private static String key(String question, String context) {
        return normalize(question) + "||" + normalize(context);
    }

    private static String normalize(String s) {
        if (s == null) return "";
        return s.trim().replaceAll("\\s+", " ").toLowerCase(Locale.ROOT);
    }
}
