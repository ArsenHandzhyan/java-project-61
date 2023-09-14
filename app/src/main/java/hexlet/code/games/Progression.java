package hexlet.code.games;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class Progression {
    private static final int MIN_NUMBER = 5;
    private static final int BOUND_LENGTH = 6;
    private static final int STEP_START = 1;
    private static final int BOUND_STEP = 25;
    private static final int BOUND_START = 101;

    public static void gameStart() {
        System.out.println("What number is missing in the progression?");
        newGame(0);
    }

    public static void newGame(int count) {
        String[] results = generate();
        String progression = results[0];
        String result = results[1];
        System.out.println("Question: " + progression);
        String game = "5";
        game(count, result, game);
    }

    public static String[] generate() {
        int[] progression = generateProgression();
        int hiddenIndex = hideElement(progression);
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
        int length = randomGen(BOUND_LENGTH) + MIN_NUMBER; // Генерация случайной длины от 5 до 10
        int[] progression = new int[length];
        int start = randomGen(BOUND_START) + MIN_NUMBER; // Генерация случайного начального числа
        int step = randomGen(BOUND_STEP) + STEP_START; // Генерация шага
        for (int i = 0; i < length; i++) {
            progression[i] = start + (i * step); // Шаг арифметической прогрессии равен step
        }

        return progression;
    }

    public static int hideElement(int[] progression) {
        return randomGen(progression.length);
    }
}
