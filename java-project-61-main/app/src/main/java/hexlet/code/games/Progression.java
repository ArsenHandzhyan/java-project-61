package hexlet.code.games;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class Progression {

    public static void gameStart() {
        System.out.println("What number is missing in the progression?");
        newGame(0);
    }

    public static void newGame(int count) {
        String[] results = generate();
        String progression = results[0];
        String result = results[1];
        System.out.println("Question: " + progression);
        game(count, result, 5);
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
        int length = randomGen(6) + 5; // Генерация случайной длины от 5 до 10
        int[] progression = new int[length];
        int start = randomGen(100); // Генерация случайного начального числа
        int step = randomGen(25) + 1;
        for (int i = 0; i < length; i++) {
            progression[i] = start + (i * step); // Шаг арифметической прогрессии равен step
        }

        return progression;
    }

    public static int hideElement(int[] progression) {
        return randomGen(progression.length);
    }
}
