package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_NUMBER = 1; // Ограничение общего делителя  от
    private static final int BOUND_GCD = 30; // Ограничение общего делителя  до
    private static final int BOUND_MULTIPLIER = 20; // Ограничение вспомогательного множителя для чисел до

    public static void startPlay() {
        String[] round1 = generateRoundData(0);
        String[] round2 = generateRoundData(1);
        String[] round3 = generateRoundData(2);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] generateRoundData(int count) {
        int generatedGCD = getRandomInt(BOUND_GCD, MIN_NUMBER);
        int multiplayer1 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        int multiplayer2 = getRandomInt(BOUND_MULTIPLIER, MIN_NUMBER);
        int num1 = generatedGCD * multiplayer1;  // Рассчитываем числа с учетом общего делителя
        int num2 = generatedGCD * multiplayer2;
        String countGame = Integer.toString(count);
        String expression = num1 + " " + num2;
        String result = String.valueOf(getNumGCD(num1, num2));
        return new String[]{result, expression, countGame};
    }

    public static int getNumGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return getNumGCD(num2, num1 % num2);
        }
    }
}
