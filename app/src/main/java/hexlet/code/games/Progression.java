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
        run(DESCRIPTION, roundsData);
    }

    public static String[] generateRoundData() {
        int generatedLength = getRandomInt(MIN_NUMBER, BOUND_LENGTH);
        int generatedStartNumber = getRandomInt(MIN_NUMBER, BOUND_START);
        int generatedStepNumber = getRandomInt(STEP_START, BOUND_STEP);
        String[] results = generateQuestion(generatedLength, generatedStartNumber, generatedStepNumber);
        String answer = results[0];
        String result = results[1];
        return new String[]{result, answer};
    }

    public static int[] generateProgression(int lengthNumber, int startNumber, int stepNumber) {
        int[] progression = new int[lengthNumber];
        for (int i = 0; i < lengthNumber; i++) {
            progression[i] = startNumber + (i * stepNumber);
        }
        return progression;
    }

    public static String[] generateQuestion(int lengthNumber, int startNumber, int stepNumber) {
        int[] progression = generateProgression(lengthNumber, startNumber, stepNumber);
        int hiddenIndex = getRandomInt(0, progression.length);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i != hiddenIndex) {
                stringBuilder.append(progression[i]).append(" ");
            } else {
                stringBuilder.append(".. ");
            }
        }
        String answer = stringBuilder.toString().trim();
        String result = getResult(progression[hiddenIndex]);
        return new String[]{answer, result};
    }

    public static String getResult(int hiddenIndex) {
        return String.valueOf(hiddenIndex);
    }
}
