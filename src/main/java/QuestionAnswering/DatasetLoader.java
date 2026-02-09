package QuestionAnswering;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class DatasetLoader {
    private final ObjectMapper mapper = new ObjectMapper();

    public Dataset load(InputStream in) throws IOException {
        return mapper.readValue(in, Dataset.class);
    }
}
