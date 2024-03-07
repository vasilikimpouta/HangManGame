import java.io.IOException;
import java.util.Random;

public class WordRepository {

    private final RandomWordApiClient randomWordApiClient = new RandomWordApiClient();

    public String getRandomWord() throws IOException {
        return randomWordApiClient.randomWord();
    }
}
