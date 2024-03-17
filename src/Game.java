import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Game {

    private final String word;
    private List<Character> letters = new ArrayList<>();

    private List<Character> wrongLetters = new ArrayList<>();
    private List<Character> rightGuessLetters = new ArrayList<>();

    public Game(String word) {
        this.word = word;
    }

    public void startGame() {
        for (int i = 0; i < word.length(); i++) {
            letters.add(word.charAt(i));
        }
        rightGuessLetters.add(letters.get(0));
        System.out.println(foo());
    }

    public void resumeGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (wrongLetters.size() < 3) {
            if(foo().equals(word)){
                System.out.println("you found the word!!!");
                break;
            }
            System.out.println(" choose a letter");
            Character input = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
            boolean isContained = letters.contains(input);
            if (isContained) {
                rightGuessLetters.add(input);
            } else {
                wrongLetters.add(input);
            }
            System.out.println(foo() + "   wrong letters: " + wrongLetters);
        }
        System.out.println(word);
        List<Meaning> meanings = DefinitionApiClient.getDefinition(word);
        for(Meaning meaning: meanings){
            System.out.println(meaning);
        }
    }
    private String foo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character letter : letters) {
            if (rightGuessLetters.contains(letter)) {
                stringBuilder.append(letter);
            } else {
                stringBuilder.append('_');
            }
        }
        return stringBuilder.toString();
    }
}
