import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DefinitionApiClient {

    public static String getDefinition(String word) throws IOException {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/" + word);
        return ApiClientHelper.doGetRequest(url);
    }
}
