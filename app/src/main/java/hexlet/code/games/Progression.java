package hexlet.code.games;

import static hexlet.code.Engine.generateNumber;
import static hexlet.code.Engine.getcount;

public class Progression {
    private static final int MIN_NUMBER = 5;
    private static final int BOUND_LENGTH = 6;
    private static final int STEP_START = 1;
    private static final int BOUND_STEP = 25;
    private static final int BOUND_START = 101;

    public static void startPlay() {
        System.out.println("What number is missing in the progression?");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        String[] results = generateQuestion();
        String progression = results[0];
        String result = results[1];
        System.out.println("Question: " + progression);
        if (getcount(count, result) == 1) {
            newGamePlay(++count);
        }
    }

    public static String[] generateQuestion() {
        int[] progression = generateProgression();
        int hiddenIndex = getHidenElement(progression);
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

    public static int[] generateProgression() {
        int length = generateNumber(BOUND_LENGTH) + MIN_NUMBER; // Генерация случайной длины от 5 до 10
        int[] progression = new int[length];
        int start = generateNumber(BOUND_START) + MIN_NUMBER; // Генерация случайного начального числа
        int step = generateNumber(BOUND_STEP) + STEP_START; // Генерация шага
        for (int i = 0; i < length; i++) {
            progression[i] = start + (i * step); // Шаг арифметической прогрессии равен step
        }
        return progression;
    }

    public static int getHidenElement(int[] progression) {
        return generateNumber(progression.length);
    }
}
