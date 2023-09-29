package hexlet.code.games;

import static hexlet.code.Engine.getIsSimple;
import static hexlet.code.Engine.parsResult;
import static hexlet.code.Engine.getCount;
import static hexlet.code.Utils.getRandomInt;

public class Prime {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 501;

    public static void startPlay() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int results = getRandomInt(BOUND, MIN_NUMBER);
        String number = Integer.toString(results);
        String result = String.valueOf(getIsSimple(results));
        System.out.println("Question: " + number);
        String result1 = parsResult(result);
        if (getCount(count, result1) == 1) {
            newGamePlay(++count);
        }
    }
}
