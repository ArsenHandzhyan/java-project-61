package hexlet.code.games;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class GCD {
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от 1
    private static final int BOUND_GCD = 31; // Ограничение общего делителя  до 31
    private static final int BOUND_MULTIPLIER = 21; // Ограничение вспомогательного множителя для чисел до 21

    public static void gameStart() {
        System.out.println("Find the greatest common divisor of given numbers.");
        newGame(0);
    }

    public static void newGame(int count) {
        int gcd = randomGen(BOUND_GCD) + MIN_NUMBER; // Ограничение общего делителя от 1 до 31
        int multiplier1 = randomGen(BOUND_MULTIPLIER) + MIN_NUMBER; // Генерируем вспомогательные множители для чисел
        int multiplier2 = randomGen(BOUND_MULTIPLIER) + MIN_NUMBER;
        int num1 = gcd * multiplier1;  // Рассчитываем числа с учетом общего делителя
        int num2 = gcd * multiplier2;
        String expression = num1 + " " + num2;
        String result = Integer.toString(findGCD(num1, num2));
        System.out.println("Question: " + expression);
        String game = "4";
        game(count, result, game);
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}

