package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Generate;

import static hexlet.code.Generate.randomGen;
import static hexlet.code.Generate.string;

public class Calc implements Generate {

    public static void gameStart() {
        System.out.println("\nWhat is the result of the expression?");
        game(0);
    }


    public static String generateSign() {
        int sign = randomGen(3);

        return switch (sign) {
            case 1 -> "-";
            case 2 -> "*";
            default -> "+"; // По умолчанию возвращаем "+"
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
                return "0"; // Default to "0"
            }
        }
    }

    public static void game(int count) {
        int num1 = randomGen(50) + 1;
        int num2 = randomGen(50) + 1;

        String sign = generateSign();
        String expression = num1 + " " + sign + " " + num2;
        String result = calculateExpression(num1, num2, sign);

        System.out.println("Question: " + expression);

        String input = string();

        if (count <= 2) {
            if (result.equals(input)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    Engine.gameEngine();
                } else {
                    game(++count);
                }
            } else {
                System.out.println("Your answer: " + input);
                System.out.println("'" + input + "'" + "is wrong answer ;(. Correct answer was" + "'" + result + "'");
                Engine.again();
                Engine.gameEngine();
            }
        } else {
            Engine.gameEngine();
        }
    }
}





