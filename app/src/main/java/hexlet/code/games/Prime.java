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
        String result = getResult(generatedNumber);
        return new String[]{result, answer};
    }

    public static boolean isSimple(int generatedNumber) {
        if (generatedNumber < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(generatedNumber); i++) {
            if (generatedNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String getResult(int generatedNumber) {
        return isSimple(generatedNumber) ? "yes" : "no";
    }
}
