package hexlet.code.games;

import static hexlet.code.Utils.getRandomInt;
import static hexlet.code.RoundsDataMaker.roundsData;

public class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 50;

    public static void startPlay() {
        String[] round1 = generateRoundData(0);
        String[] round2 = generateRoundData(1);
        String[] round3 = generateRoundData(2);
        roundsData(round1, round2, round3, DESCRIPTION);
    }

    public static String[] generateRoundData(int count) {
        int generatedNumber1 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        int generatedNumber2 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        int generatedSign1 = getRandomInt(BOUND_SIGN, MIN_SIGN);
        String countGame = Integer.toString(count);
        String sign = generateSign(generatedSign1);
        String questions = generatedNumber1 + " " + sign + " " + generatedNumber2;
        String result = String.valueOf(calculateExpression(generatedNumber1, generatedNumber2, sign));
        return new String[]{result, questions, countGame};
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
