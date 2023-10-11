package hexlet.code.games;

import static hexlet.code.Utils.getRandomInt;
import static hexlet.code.games.RoundsDataMaker.roundsData;

public class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 1000;

    public static void startPlay() {
        roundsData(generateRoundData(0), generateRoundData(1), generateRoundData(2), DESCRIPTION);
    }

    public static String[] generateRoundData(int count) {
        int generatedNumber = getRandomInt(BOUND, MIN_NUMBER);
        String countGame = Integer.toString(count);
        String questions = Integer.toString(generatedNumber);
        boolean isSimple = isSimple(generatedNumber);
        String result = isSimple ? "yes" : "no";
        return new String[]{result, questions, countGame};
    }

    public static boolean isSimple(Integer number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
