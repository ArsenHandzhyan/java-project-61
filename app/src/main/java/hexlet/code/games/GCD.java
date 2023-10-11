package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от
    private static final int BOUND_GCD = 30; // Ограничение общего делителя  до
    private static final int BOUND_MULTIPLIER = 20; // Ограничение вспомогательного множителя для чисел до
    private static int generateGCD = getRandomInt(BOUND_GCD, MIN_NUMBER); // Ограничение общего делителя
    private static int generateMultiplayer = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER); // вспомогательные множители



    public static void startPlay() {
        String[] round1 = roundsData(0);
        generateGCD = getRandomInt(BOUND_GCD, MIN_NUMBER);
        generateMultiplayer = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        String[] round2 = roundsData(1);
        generateGCD = getRandomInt(BOUND_GCD, MIN_NUMBER);
        generateMultiplayer = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        String[] round3 = roundsData(2);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }
    public static String[] roundsData(int count1) {
        int num1 = generateGCD * generateMultiplayer;  // Рассчитываем числа с учетом общего делителя
        generateGCD = getRandomInt(BOUND_GCD, MIN_NUMBER);
        generateMultiplayer = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        int num2 = generateGCD * generateMultiplayer;
        String count = Integer.toString(count1);
        String expression = num1 + " " + num2;
        String result = String.valueOf(getNumGCD(num1, num2));
        return new String[]{result, expression, count};
    }

    public static int getNumGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getNumGCD(b, a % b);
        }
    }
}
