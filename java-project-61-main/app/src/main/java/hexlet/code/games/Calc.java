package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc {

    static Scanner sc = new Scanner(System.in);

    public static void gameStart1() {
        System.out.println("What is the result of the expression?");
        game(0);
    }

    public static int randomGen() {
        Random random = new Random();
        return random.nextInt(20);
    }

    public static String generateSign() {
        Random rand = new Random();
        int sign = rand.nextInt(3);

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
        int num1 = randomGen();
        int num2 = randomGen();

        String sign = generateSign();
        String expression = num1 + " " + sign + " " + num2;
        String result = calculateExpression(num1, num2, sign);

        System.out.println("Question: " + expression);

        String input = sc.nextLine();

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





