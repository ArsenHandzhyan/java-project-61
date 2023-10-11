package hexlet.code.games;


import static hexlet.code.Utils.getRandomInt;
import static hexlet.code.games.RoundsDataMaker.roundsData;

public class Even {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'";

    public static void startPlay() {
        roundsData(generateRoundData(0), generateRoundData(1), generateRoundData(2), DESCRIPTION);
    }

    private static String[] generateRoundData(int count) {
        int number = getRandomInt(BOUND, MIN_NUMBER);
        String countGame = Integer.toString(count);
        String result = isParityResult(number) ? "yes" : "no";
        String questions = Integer.toString(number);
        return new String[]{result, questions, countGame};
    }

    private static boolean isParityResult(int evenNum) {
        return evenNum % 2 == 0;
    }
}
