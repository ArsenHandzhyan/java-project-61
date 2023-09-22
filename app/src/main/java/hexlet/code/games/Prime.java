package hexlet.code.games;

import static hexlet.code.Engine.generateNumber;
import static hexlet.code.Engine.getcount;

public class Prime {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 501;

    public static void startPlay() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int results = generateNumber(BOUND) + MIN_NUMBER;
        String number = Integer.toString(results);
        String result = getIsSimple(results);
        System.out.println("Question: " + number);
        if (getcount(count, result) == 1) {
            newGamePlay(++count);
        }
    }

    public static String getIsSimple(Integer number) {
        if (number < 2) {
            return "no";
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
