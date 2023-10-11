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
    static int generatedLength1 = getRandomInt(BOUND_LENGTH, MIN_NUMBER);
    static int generatedLength2 = getRandomInt(BOUND_LENGTH, MIN_NUMBER);
    static int generatedLength3 = getRandomInt(BOUND_LENGTH, MIN_NUMBER);
    static int generatedStartNumber1 = getRandomInt(BOUND_START, MIN_NUMBER);
    static int generatedStartNumber2 = getRandomInt(BOUND_START, MIN_NUMBER);
    static int generatedStartNumber3 = getRandomInt(BOUND_START, MIN_NUMBER);
    static int generatedStepNumber1 = getRandomInt(BOUND_STEP, STEP_START);
    static int generatedStepNumber2 = getRandomInt(BOUND_STEP, STEP_START);
    static int generatedStepNumber3 = getRandomInt(BOUND_STEP, STEP_START);

    public static void startPlay() {
        String[] round1 = roundsData(0, generatedLength1, generatedStartNumber1, generatedStepNumber1);
        String[] round2 = roundsData(1, generatedLength2, generatedStartNumber2, generatedStepNumber2);
        String[] round3 = roundsData(2, generatedLength3, generatedStartNumber3, generatedStepNumber3);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1, int lengthNumber, int startNumber, int stepNumber) {
        String[] results = generateQuestionForProgression(lengthNumber, startNumber, stepNumber);
        String count = Integer.toString(count1);
        String questions = results[0];
        String result = results[1];
        return new String[]{result, questions, count};
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
