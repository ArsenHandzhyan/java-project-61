package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Prime {
    private static final int GAME_NUMBER = 6;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 1000;

    public static void startPlay(int count) {
        String[] results = roundsData(count);
        run(DESCRIPTION, results);
    }

    public static String[] roundsData(int count) {
        int results = getRandomInt(BOUND, MIN_NUMBER);
        String number = Integer.toString(results);
        String result = parsResult(String.valueOf(getIsSimple(results)));
        return new String[]{result, number, Integer.toString(GAME_NUMBER), Integer.toString(count)};
    }

    public static boolean getIsSimple(Integer number) {
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
    public static String parsResult(String result) {
        return switch (result) {
            case "true" -> "yes";
            case "false" -> "no";
            default -> throw new Error("Unknown result!");
        };
    }
}
