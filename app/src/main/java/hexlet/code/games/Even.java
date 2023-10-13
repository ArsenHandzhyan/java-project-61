package hexlet.code.games;

import static hexlet.code.Engine.runGameRounds;
import static hexlet.code.Utils.getRandomInt;

public class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 101;

    public static void startPlay() {
        runGameRounds(DESCRIPTION, Even::generateRoundData);
    }

    private static String[] generateRoundData() {
        int generatedNumber = getRandomInt(BOUND, MIN_NUMBER);
        String result = generatedNumber % 2 == 0 ? "yes" : "no";
        String questions = Integer.toString(generatedNumber);
        return new String[]{result, questions};
    }
}
