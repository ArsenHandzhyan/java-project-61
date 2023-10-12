package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MIN_NUMBER = 5;
    private static final int BOUND_LENGTH = 10;
    private static final int STEP_START = 1;
    private static final int BOUND_STEP = 25;
    private static final int BOUND_START = 100;

    public static void startPlay() {
        String[] round1 = generateRoundData();
        String[] round2 = generateRoundData();
        String[] round3 = generateRoundData();
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] generateRoundData() {
        int generatedLength = getRandomInt(BOUND_LENGTH, MIN_NUMBER);
        int generatedStartNumber = getRandomInt(BOUND_START, MIN_NUMBER);
        int generatedStepNumber = getRandomInt(BOUND_STEP, STEP_START);
        String[] results = generateQuestionForProgression(generatedLength, generatedStartNumber, generatedStepNumber);
        String questions = results[0];
        String result = results[1];
        return new String[]{result, questions};
    }

    public static String[] generateQuestionForProgression(int lengthNumber, int startNumber, int stepNumber) {
        int[] progression = new int[lengthNumber];
        for (int i = 0; i < lengthNumber; i++) {
            progression[i] = startNumber + (i * stepNumber);
        }
        int hiddenIndex = getRandomInt(progression.length, 0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i != hiddenIndex) {
                stringBuilder.append(progression[i]).append(" ");
            } else {
                stringBuilder.append(".. ");
            }
        }
        String result1 = stringBuilder.toString().trim();
        String result2 = String.valueOf(progression[hiddenIndex]);
        return new String[]{result1, result2};
    }
}
