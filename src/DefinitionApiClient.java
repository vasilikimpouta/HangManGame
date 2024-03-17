import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class DefinitionApiClient {

    public static List<Meaning> getDefinition(String word) throws IOException {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/" + word);
        String response = ApiClientHelper.doGetRequest(url);
        ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<WordDefinition> wordDefinitions = objectMapper.readValue(response, new TypeReference<List<WordDefinition>>() {
        });
        WordDefinition firstDefinition = wordDefinitions.get(0);
        return firstDefinition.getMeanings();

    }
}
