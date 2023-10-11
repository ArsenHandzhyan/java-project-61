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
    private static int generateLength = getRandomInt(BOUND_LENGTH, MIN_NUMBER); // Генерация случайной длины от 5 до 10
    private static int generateStartNumber = getRandomInt(BOUND_START, MIN_NUMBER); // Cлучайного начального числа
    private static int generateStepNumber = getRandomInt(BOUND_STEP, STEP_START); // Генерация шага

    public static void startPlay() {
        String[] round1 = roundsData(0, generateLength, generateStartNumber, generateStepNumber);
        generateLength = getRandomInt(BOUND_LENGTH, MIN_NUMBER);
        generateStartNumber = getRandomInt(BOUND_START, MIN_NUMBER);
        generateStepNumber = getRandomInt(BOUND_STEP, STEP_START);
        String[] round2 = roundsData(1, generateLength, generateStartNumber, generateStepNumber);
        generateLength = getRandomInt(BOUND_LENGTH, MIN_NUMBER);
        generateStartNumber = getRandomInt(BOUND_START, MIN_NUMBER);
        generateStepNumber = getRandomInt(BOUND_STEP, STEP_START);
        String[] round3 = roundsData(2, generateLength, generateStartNumber, generateStepNumber);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1, int generateLength, int generateStartNumber, int generateStepNumber) {
        String[] results = generateQuestionForProgression(generateLength, generateStartNumber, generateStepNumber);
        String count = Integer.toString(count1);
        String questions = results[0];
        String result = results[1];
        return new String[]{result, questions, count};
    }

    public static String[] generateQuestionForProgression(int generateLength, int generateStartNumber, int generateStepNumber) {
        int[] progression = new int[generateLength];
        for (int i = 0; i < generateLength; i++) {
            progression[i] = generateStartNumber + (i * generateStepNumber);
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
