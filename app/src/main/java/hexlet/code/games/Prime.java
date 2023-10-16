package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 1000;

    public static void startPlay() {
        String[] round1 = generateRoundData();
        String[] round2 = generateRoundData();
        String[] round3 = generateRoundData();
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData);
    }

    public static String[] generateRoundData() {
        int generatedNumber = getRandomInt(MIN_NUMBER, BOUND);
        String answer = Integer.toString(generatedNumber);
        boolean isSimple = isSimple(generatedNumber);
        String result = getResult(isSimple);
        return new String[]{result, answer};
    }

    public static boolean isSimple(int number) {
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

    public static String getResult(boolean isSimple) {
        return isSimple ? "yes" : "no";
    }
}
