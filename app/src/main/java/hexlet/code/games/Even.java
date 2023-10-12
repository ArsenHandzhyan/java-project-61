package hexlet.code.games;


import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;

    public static void startPlay() {
        String[] round1 = generateRoundData();
        String[] round2 = generateRoundData();
        String[] round3 = generateRoundData();
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    private static String[] generateRoundData() {
        int generatedNumber = getRandomInt(BOUND, MIN_NUMBER);
        String result = isParityResult(generatedNumber) ? "yes" : "no";
        String questions = Integer.toString(generatedNumber);
        return new String[]{result, questions};
    }

    private static boolean isParityResult(int evenNum) {
        return evenNum % 2 == 0;
    }
}
