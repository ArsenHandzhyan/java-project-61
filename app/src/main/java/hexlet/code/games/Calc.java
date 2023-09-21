package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.randomGen;

public class Calc {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND_NUMBER = 51;
    private static final int BOUND_SIGN = 3;

    public static void gameStart() {
        System.out.println("What is the result of the expression?");
        newGame(0);
    }

    public static void newGame(int count) {
        int num1 = randomGen(BOUND_NUMBER) + MIN_NUMBER;
        int num2 = randomGen(BOUND_NUMBER) + MIN_NUMBER;
        String sign = generateSign();
        String expression = num1 + " " + sign + " " + num2;
        String result = String.valueOf(calculateExpression(num1, num2, sign));
        System.out.println("Question: " + expression);
        play(count, result);
    }

    public static void play(int count, String result) {
        String input = Engine.getString();
        Engine.getAnswer(input);
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulate();
                    System.exit(0);
                } else {
                    newGame(++count);
                }
            } else {
                Engine.getIncorrectAnswer(input, result);
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    public static String generateSign() {
        int sign = randomGen(BOUND_SIGN);
        return switch (sign) {
            case 1 -> "-";
            case 2 -> "*";
            default -> "+";
        };
    }

    public static int calculateExpression(int num1, int num2, String sign) {
        switch (sign) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "*" -> {
                return num1 * num2;
            }
            default -> {
                return 0;
            }
        }
    }
}





