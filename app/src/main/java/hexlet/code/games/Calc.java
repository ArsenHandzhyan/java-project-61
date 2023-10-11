package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 50;
    private static int generateNumber = getRandomInt(BOUND_NUMBER, MIN_NUMBER);


    public static void startPlay() {
        String[] round1 = roundsData(0);
        generateNumber = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        String[] round2 = roundsData(1);
        generateNumber = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        String[] round3 = roundsData(2);
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData, 0);
    }

    public static String[] roundsData(int count1) {
        int num1 = generateNumber;
        generateNumber = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        int num2 = generateNumber;
        String count = Integer.toString(count1);
        String sign = generateSign();
        String questions = num1 + " " + sign + " " + num2;
        String result = String.valueOf(calculateExpression(num1, num2, sign));
        return new String[]{result, questions, count};
    }

    public static String generateSign() {
        int sign = getRandomInt(BOUND_SIGN, MIN_SIGN);
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
