package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;


public class Even {
    private static final int GAME_NUMBER = 2;
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;


    public static void startPlay(int count) {
        String[] results = roundsData(count);
        run(DESCRIPTION, results);
    }
    public static String[] roundsData(int count) {
        int num = getRandomInt(BOUND, MIN_NUMBER);
        String result = String.valueOf(getParityResult(num));
        String result1 = parsResult(result);
        String questions = Integer.toString(num);
        return new String[]{result1, questions, Integer.toString(GAME_NUMBER), Integer.toString(count)};
    }
    public static boolean getParityResult(int evenNum) {
        return evenNum % 2 == 0;
    }

    public static String parsResult(String result) {
        return switch (result) {
            case "true" -> "yes";
            case "false" -> "no";
            default -> throw new Error("Unknown result!");
        };
    }
}
