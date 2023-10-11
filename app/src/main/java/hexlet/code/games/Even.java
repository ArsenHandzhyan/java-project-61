package hexlet.code.games;


import static hexlet.code.Utils.getRandomInt;
import static hexlet.code.RoundsDataMaker.roundsData;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;

    public static void startPlay() {
        String[] round1 = generateRoundData(0);
        String[] round2 = generateRoundData(1);
        String[] round3 = generateRoundData(2);
        roundsData(round1, round2, round3, DESCRIPTION);
    }

    private static String[] generateRoundData(int count) {
        int generatedNumber = getRandomInt(BOUND, MIN_NUMBER);
        String countGame = Integer.toString(count);
        String result = isParityResult(generatedNumber) ? "yes" : "no";
        String questions = Integer.toString(generatedNumber);
        return new String[]{result, questions, countGame};
    }

    private static boolean isParityResult(int evenNum) {
        return evenNum % 2 == 0;
    }
}
