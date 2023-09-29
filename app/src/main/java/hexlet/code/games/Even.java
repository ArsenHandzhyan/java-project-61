package hexlet.code.games;

import static hexlet.code.Engine.getParityResult;
import static hexlet.code.Engine.parsResult;
import static hexlet.code.Engine.getCount;
import static hexlet.code.Utils.getRandomInt;


public class Even {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;

    public static void startPlay() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int evenNum = getRandomInt(BOUND, MIN_NUMBER);
        String result = String.valueOf(getParityResult(evenNum));
        System.out.println("Question: " + evenNum);
        String result1 = parsResult(result);
        if (getCount(count, result1) == 1) {
            newGamePlay(++count);
        }
    }
}
