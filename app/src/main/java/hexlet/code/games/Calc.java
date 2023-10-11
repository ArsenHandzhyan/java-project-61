package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 50;
    static int generatedNumber1 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    static int generatedNumber2 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    static int generatedNumber3 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    static int generatedNumber4 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    static int generatedNumber5 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    static int generatedNumber6 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    static int generatedSign1 = getRandomInt(BOUND_SIGN, MIN_SIGN);
    static int generatedSign2 = getRandomInt(BOUND_SIGN, MIN_SIGN);
    static int generatedSign3 = getRandomInt(BOUND_SIGN, MIN_SIGN);

    public static void startPlay() {
        String[] round1 = roundsData(0, generatedNumber1, generatedNumber2, generatedSign1);
        String[] round2 = roundsData(1, generatedNumber3, generatedNumber4, generatedSign2);
        String[] round3 = roundsData(2, generatedNumber5, generatedNumber6, generatedSign3);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1, int generateNumber1, int generateNumber2, int signNumber) {
        String count = Integer.toString(count1);
        String sign = generateSign(signNumber);
        String questions = generateNumber1 + " " + sign + " " + generateNumber2;
        String result = String.valueOf(calculateExpression(generateNumber1, generateNumber2, sign));
        return new String[]{result, questions, count};
    }

    public static String generateSign(int sign) {
        return switch (sign) {
            case 0 -> "-";
            case 1 -> "*";
            case 2 -> "+";
            default -> throw new Error("Unknown sign!");
        };
    }

    public static int calculateExpression(int num1, int num2, String sign) {
        return switch (sign) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new Error("Unknown expression!");
        };
    }
}
