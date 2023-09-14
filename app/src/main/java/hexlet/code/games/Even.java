package hexlet.code.games;


import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class Even {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;

    public static void gameStart() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        newGame(0);
    }

    public static void newGame(int count) {
        int evenNum = randomGen(BOUND) + MIN_NUMBER;
        System.out.println("Question: " + evenNum);
        String game = "2";
        game(count, evenNumber(evenNum), game);
    }

    public static String evenNumber(int evenNum) {
        if (evenNum % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}

