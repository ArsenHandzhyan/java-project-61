package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Generate;

import static hexlet.code.Generate.randomGen;
import static hexlet.code.Generate.string;

public class GSD implements Generate {

    public static void gameStart() {
        System.out.println("Find the greatest common divisor of given numbers.");
        game(0);
    }

    public static void game(int count) {
        int gcd = randomGen(50); // Ограничение общего делителя от 1 до 50

        int multiplier1 = randomGen(20); // Генерируем вспомогательные множители для чисел
        int multiplier2 = randomGen(20);

        int num1 = gcd * multiplier1;  // Рассчитываем числа с учетом общего делителя
        int num2 = gcd * multiplier2;

        String expression = num1 + " " + num2;
        String result = Integer.toString(findGCD(num1, num2));

        System.out.println("Question: " + expression);

        String input = string();

        if (count <= 2) {
            if (result.equals(input)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    Engine.gameEngine();
                } else {
                    game(++count);
                }
            } else {
                System.out.println("Your answer: " + input);
                System.out.println("'" + input + "'" + "is wrong answer ;(. Correct answer was" + "'" + result + "'");
                Engine.again();
                Engine.gameEngine();
            }
        } else {
            Engine.gameEngine();
        }
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}

