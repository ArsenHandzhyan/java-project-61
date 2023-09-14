package hexlet.code.games;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class Prime {

    public static void gameStart() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        newGame(0);
    }

    public static void newGame(int count) {
        int mintNumber = 1;
        int bound = 501;
        int results = randomGen(bound) + mintNumber;
        String number = Integer.toString(results);
        boolean correctAnswer = isSimple(results);
        String result = String.valueOf(correctAnswer);
        System.out.println("Question: " + number);
        String game = "6";
        game(count, result, game);
    }

    public static boolean isSimple(Integer number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
