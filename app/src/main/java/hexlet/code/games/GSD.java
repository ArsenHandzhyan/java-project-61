package hexlet.code.games;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class GSD {

    public static void gameStart() {
        System.out.println("Find the greatest common divisor of given numbers.");
        newGame(0);
    }

    public static void newGame(int count) {
        int gcd = randomGen(31) + 1; // Ограничение общего делителя от 1 до 50
        int multiplier1 = randomGen(21) + 1; // Генерируем вспомогательные множители для чисел
        int multiplier2 = randomGen(21) + 1;
        int num1 = gcd * multiplier1;  // Рассчитываем числа с учетом общего делителя
        int num2 = gcd * multiplier2;
        String expression = num1 + " " + num2;
        String result = Integer.toString(findGCD(num1, num2));
        System.out.println("Question: " + expression);
        game(count, result, 4);
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}

