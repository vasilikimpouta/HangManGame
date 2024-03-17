import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;

public class RandomWordApiClient {


    public String randomWord() throws IOException {
        URL url = new URL("https://random-word-api.herokuapp.com/word?number=1&length=10&lang=en");
        ObjectMapper objectMapper = new ObjectMapper();

        String responseBody = ApiClientHelper.doGetRequest(url);
        List<String> list = objectMapper.readValue(responseBody,List.class);

        String word = list.get(0).toUpperCase(Locale.ROOT);


        return word;
    }
}
