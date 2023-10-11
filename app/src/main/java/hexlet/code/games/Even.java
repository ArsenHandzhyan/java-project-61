package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;
    private static int generateNumber = getRandomInt(BOUND, MIN_NUMBER);

    public static void startPlay() {
        String[] round1 = roundsData(0);
        generateNumber = getRandomInt(BOUND, MIN_NUMBER);
        String[] round2 = roundsData(1);
        generateNumber = getRandomInt(BOUND, MIN_NUMBER);
        String[] round3 = roundsData(2);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1) {
        generateNumber = getRandomInt(BOUND, MIN_NUMBER);
        int currentNum = generateNumber;
        String result = isParityResult(currentNum) ? "yes" : "no";
        String questions = Integer.toString(currentNum);
        String count = Integer.toString(count1);
        return new String[]{result, questions, count};
    }

    public static boolean isParityResult(int evenNum) {
        return evenNum % 2 == 0;
    }
}
