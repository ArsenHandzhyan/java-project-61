package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 50;
    private static int generateNumber1 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    private static int generateNumber2 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
    private static int generateSign = getRandomInt(BOUND_SIGN, MIN_SIGN);


    public static void startPlay() {
        String[] round1 = roundsData(0, generateNumber1, generateNumber2);
        generateNumber1 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        generateNumber2 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        generateSign = getRandomInt(BOUND_SIGN, MIN_SIGN);
        String[] round2 = roundsData(1, generateNumber1, generateNumber2);
        generateNumber1 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        generateNumber2 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        generateSign = getRandomInt(BOUND_SIGN, MIN_SIGN);
        String[] round3 = roundsData(2, generateNumber1, generateNumber2);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1, int generateNumber1, int generateNumber2) {
        String count = Integer.toString(count1);
        String sign = generateSign(generateSign);
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
