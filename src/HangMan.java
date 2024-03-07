import java.io.IOException;
import java.util.*;

public class HangMan {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        WordRepository wordRepository = new WordRepository();
        String answer;

       do{
          String word = wordRepository.getRandomWord();
            Game game = new Game(word);
            game.startGame();
            game.resumeGame();
            System.out.println(" Do you want to play again?");
            answer = scanner.nextLine();

        } while(answer.equals("yes"));
    }

}
