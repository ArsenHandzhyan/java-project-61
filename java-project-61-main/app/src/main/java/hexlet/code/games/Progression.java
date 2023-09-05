package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Progression {
    static Scanner sc = new Scanner(System.in);

    public static void gameStart1() {
        System.out.println("What number is missing in the progression?");
        game(0);
    }

    public static void game(int count) {
        String[] results = generate();
        String result = results[0];
        String hiddenNumber = results[1];
        System.out.println("Question: " + result);
        String input = sc.nextLine();
        if (count <= 2) {
            if (input.equals(hiddenNumber)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    Engine.gameEngine();
                } else {
                    game(++count);
                }
            } else {
                System.out.println("Your answer: " + input);
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.print("'" + hiddenNumber + "'");
                Engine.again();
                Engine.gameEngine();
            }
        } else {
            Engine.gameEngine();
        }
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
        Random random = new Random();
        int length = random.nextInt(6) + 5; // Генерация случайной длины от 5 до 10
        int[] progression = new int[length];
        int start = random.nextInt(100); // Генерация случайного начального числа

        for (int i = 0; i < length; i++) {
            progression[i] = start + (i * 3); // Шаг арифметической прогрессии равен 3
        }

        return progression;
    }

    public static int hideElement(int[] progression) {
        Random random = new Random();
        return random.nextInt(progression.length);
    }
}
