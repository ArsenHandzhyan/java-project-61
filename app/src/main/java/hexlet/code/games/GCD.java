package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от
    private static final int BOUND_GCD = 30; // Ограничение общего делителя  до
    private static final int BOUND_MULTIPLIER = 20; // Ограничение вспомогательного множителя для чисел до
    static int generateGCD1 = getRandomInt(BOUND_GCD, MIN_NUMBER); // Ограничение общего делителя
    static int generateGCD2 = getRandomInt(BOUND_GCD, MIN_NUMBER);
    static int generateGCD3 = getRandomInt(BOUND_GCD, MIN_NUMBER);
    static int multiplayer1 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER); // вспомогательные множители
    static int multiplayer2 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
    static int multiplayer3 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
    static int multiplayer4 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
    static int multiplayer5 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
    static int multiplayer6 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);


    public static void startPlay() {
        String[] round1 = roundsData(0, multiplayer1, multiplayer2, generateGCD1);
        String[] round2 = roundsData(1, multiplayer3, multiplayer4, generateGCD2);
        String[] round3 = roundsData(2, multiplayer5, multiplayer6, generateGCD3);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1, int genMultiplayer1, int genMultiplayer2, int generatedGCD) {
        int num1 = generatedGCD * genMultiplayer1;  // Рассчитываем числа с учетом общего делителя
        int num2 = generatedGCD * genMultiplayer2;
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
