package hexlet.code.games;

import static hexlet.code.Engine.getCount;
import static hexlet.code.Utils.getRandomInt;

public class Calc {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 51;
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;

    public static void startPlay() {
        System.out.println("What is the result of the expression?");
        newGamePlay(0);
    }

    public static void newGamePlay(int count) {
        int num1 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        int num2 = getRandomInt(BOUND_NUMBER, MIN_NUMBER);
        String sign = generateSign();
        String expression = num1 + " " + sign + " " + num2;
        String result = String.valueOf(calculateExpression(num1, num2, sign));
        System.out.println("Question: " + expression);
        if (getCount(count, result) == 1) {
            newGamePlay(++count);
        }
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
