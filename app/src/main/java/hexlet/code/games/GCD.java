package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class GCD {
    private static final int GAME_NUMBER = 4;
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от
    private static final int BOUND_GCD = 30; // Ограничение общего делителя  до
    private static final int BOUND_MULTIPLIER = 20; // Ограничение вспомогательного множителя для чисел до

    public static void startPlay(int count) {
        String[] results = roundsData(count);
        run(DESCRIPTION, results);
    }
    public static String[] roundsData(int count) {
        int gcd = getRandomInt(BOUND_GCD, MIN_NUMBER); // Ограничение общего делителя от MIN_NUMBER до
        int multiplier1 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER); // Генерируем вспомогательные множители
        int multiplier2 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        int num1 = gcd * multiplier1;  // Рассчитываем числа с учетом общего делителя
        int num2 = gcd * multiplier2;
        String expression = num1 + " " + num2;
        String result = String.valueOf(getNumGCD(num1, num2));
        return new String[]{result, expression, Integer.toString(GAME_NUMBER), Integer.toString(count)};
    }

    public static int getNumGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getNumGCD(b, a % b);
        }
    }
}
