package hexlet.code.games;

import static hexlet.code.Engine.generateNumber;
import static hexlet.code.Engine.getcount;

public class Even {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;

    public static void startPlay() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int evenNum = generateNumber(BOUND) + MIN_NUMBER;
        System.out.println("Question: " + evenNum);
        String result = getParityResult(evenNum);
        if (getcount(count, result) == 1) {
            newGamePlay(++count);
        }
    }

    public static String getParityResult(int evenNum) {
        if (evenNum % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
