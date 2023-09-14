package hexlet.code.games;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.game;

public class Calc {

    public static void gameStart() {
        System.out.println("What is the result of the expression?");
        newGame(0);
    }

    public static void newGame(int count) {
        int startNumber = 1;
        int num1 = randomGen(50) + startNumber;
        int num2 = randomGen(50) + startNumber;
        String sign = generateSign();
        String expression = num1 + " " + sign + " " + num2;
        String result = calculateExpression(num1, num2, sign);
        System.out.println("Question: " + expression);
        String game = "3";
        game(count, result, game);
    }

    public static String generateSign() {
        int sign = randomGen(3);
        return switch (sign) {
            case 1 -> "-";
            case 2 -> "*";
            default -> "+";
        };
    }

    public static String calculateExpression(int num1, int num2, String sign) {
        switch (sign) {
            case "+" -> {
                return Integer.toString(num1 + num2);
            }
            case "-" -> {
                return Integer.toString(num1 - num2);
            }
            case "*" -> {
                return Integer.toString(num1 * num2);
            }
            default -> {
                return "0";
            }
        }
    }
}





