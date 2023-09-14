package hexlet.code.games;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class GCD {

    public static void gameStart() {
        System.out.println("Find the greatest common divisor of given numbers.");
        newGame(0);
    }

    public static void newGame(int count) {
        int startNumber = 1;
        int gcd = randomGen(31) + startNumber; // Ограничение общего делителя от 1 до 50
        int multiplier1 = randomGen(21) + startNumber; // Генерируем вспомогательные множители для чисел
        int multiplier2 = randomGen(21) + startNumber;
        int num1 = gcd * multiplier1;  // Рассчитываем числа с учетом общего делителя
        int num2 = gcd * multiplier2;
        String expression = num1 + " " + num2;
        String result = Integer.toString(findGCD(num1, num2));
        System.out.println("Question: " + expression);
        int game = 4;
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

