package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от
    private static final int BOUND_GCD = 30; // Ограничение общего делителя  до
    private static final int BOUND_MULTIPLIER = 20; // Ограничение вспомогательного множителя для чисел до
    private static int generateGCD1 = getRandomInt(BOUND_GCD, MIN_NUMBER); // Ограничение общего делителя
    private static int generateGCD2 = getRandomInt(BOUND_GCD, MIN_NUMBER);
    private static int generateMultiplayer = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER); // вспомогательные множители


    public static void startPlay() {
        String[] round1 = roundsData(0, generateGCD1, generateGCD2, generateMultiplayer);
        generateGCD1 = getRandomInt(BOUND_GCD, MIN_NUMBER);
        generateGCD2 = getRandomInt(BOUND_GCD, MIN_NUMBER);
        generateMultiplayer = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        String[] round2 = roundsData(1, generateGCD1, generateGCD2, generateMultiplayer);
        generateGCD1 = getRandomInt(BOUND_GCD, MIN_NUMBER);
        generateGCD2 = getRandomInt(BOUND_GCD, MIN_NUMBER);
        generateMultiplayer = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        String[] round3 = roundsData(2, generateGCD1, generateGCD2, generateMultiplayer);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1, int generateGCD1, int generateGCD2, int generateMultiplayer) {
        int num1 = generateGCD1 * generateMultiplayer;  // Рассчитываем числа с учетом общего делителя
        int num2 = generateGCD2 * generateMultiplayer;
        String count = Integer.toString(count1);
        String expression = num1 + " " + num2;
        String result = String.valueOf(getNumGCD(num1, num2));
        return new String[]{result, expression, count};
    }

    public static int getNumGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return getNumGCD(num2, num1 % num2);
        }
    }
}
