package hexlet.code.games;

import static hexlet.code.Engine.run;
import static hexlet.code.Utils.getRandomInt;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 50;

    public static void startPlay() {
        String[] round1 = generateRoundData();
        String[] round2 = generateRoundData();
        String[] round3 = generateRoundData();
        String[][] roundsData = {round1, round2, round3};
        run(DESCRIPTION, roundsData);
    }

    public static String[] generateRoundData() {
        int generatedNumber1 = getRandomInt(MIN_NUMBER, BOUND_NUMBER);
        int generatedNumber2 = getRandomInt(MIN_NUMBER, BOUND_NUMBER);
        int generatedSign = getRandomInt(MIN_SIGN, BOUND_SIGN);
        String sign = generateSign(generatedSign);
        String answer = generatedNumber1 + " " + sign + " " + generatedNumber2;
        String result = getResult(generatedNumber1, generatedNumber2, sign);
        return new String[]{result, answer};
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

    public static String getResult(int generatedNumber1, int generatedNumber2, String sign) {
        return String.valueOf(calculateExpression(generatedNumber1, generatedNumber2, sign));
    }
}
