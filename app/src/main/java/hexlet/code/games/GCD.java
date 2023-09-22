package hexlet.code.games;

import static hexlet.code.Engine.generateNumber;
import static hexlet.code.Engine.getcount;

public class GCD {
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от 1
    private static final int BOUND_GCD = 31; // Ограничение общего делителя  до 31
    private static final int BOUND_MULTIPLIER = 21; // Ограничение вспомогательного множителя для чисел до 21

    public static void startPlay() {
        System.out.println("Find the greatest common divisor of given numbers.");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int gcd = generateNumber(BOUND_GCD) + MIN_NUMBER; // Ограничение общего делителя от 1 до 31
        int multiplier1 = generateNumber(BOUND_MULTIPLIER) + MIN_NUMBER; // Генерируем вспомогательные множители
        int multiplier2 = generateNumber(BOUND_MULTIPLIER) + MIN_NUMBER;
        int num1 = gcd * multiplier1;  // Рассчитываем числа с учетом общего делителя
        int num2 = gcd * multiplier2;
        String expression = num1 + " " + num2;
        String result = String.valueOf(getFindGCD(num1, num2));
        System.out.println("Question: " + expression);
        if (getcount(count, result) == 1) {
            newGamePlay(++count);
        }
    }

    public static int getFindGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getFindGCD(b, a % b);
        }
    }
}
