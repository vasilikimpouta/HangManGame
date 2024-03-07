import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class RandomWordApiClient {


    public String randomWord() throws IOException {
        URL url = new URL("https://random-word-api.herokuapp.com/word?number=1&length=10&lang=en");
       String responseBody= ApiClientHelper.doGetRequest(url);
        String word = responseBody.replaceAll("\"", "")
                .replaceFirst("\\[", "")
                .replaceFirst("\\]", "").toUpperCase(Locale.ROOT);


        return word;
    }
}
