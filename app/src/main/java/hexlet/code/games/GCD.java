package hexlet.code.games;

import static hexlet.code.Engine.getNumGCD;
import static hexlet.code.Engine.askQuestion;
import static hexlet.code.Engine.getCount;
import static hexlet.code.Utils.getRandomInt;

public class GCD {
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от 1
    private static final int BOUND_GCD = 31; // Ограничение общего делителя  до 31
    private static final int BOUND_MULTIPLIER = 21; // Ограничение вспомогательного множителя для чисел до 21

    public static void startPlay() {
        System.out.println("Find the greatest common divisor of given numbers.");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int gcd = getRandomInt(BOUND_GCD, MIN_NUMBER); // Ограничение общего делителя от 1 до 31
        int multiplier1 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER); // Генерируем вспомогательные множители
        int multiplier2 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        int num1 = gcd * multiplier1;  // Рассчитываем числа с учетом общего делителя
        int num2 = gcd * multiplier2;
        String expression = num1 + " " + num2;
        String result = String.valueOf(getNumGCD(num1, num2));
        askQuestion(expression);
        if (getCount(count, result) == 1) {
            newGamePlay(++count);
        }
    }
}
