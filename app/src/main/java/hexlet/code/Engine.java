package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Utils.getRandomInt;

public class Engine {
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;
    private static String name1;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void greetings() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        greetings1();
    }

    public static void greetings1() {
        String name = getString();
        System.out.print("Hello, " + name + "!\n");
        name1 = name;
    }

    public static void askQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static String getString() {
        return SCANNER.nextLine();
    }

    public static void getAnswer(String input) {
        System.out.println("Your answer: " + input);
    }

    public static void congratulate() {
        System.out.println("Congratulations, " + name1 + "!");
        System.exit(0);
    }

    public static void getIncorrectAnswer(String input, String result) {
        System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
        System.out.println("'" + result + "'");
        System.out.println("Let's try again, " + name1 + "!");
    }


    public static int getCount(int count, String result) {
        String input = getString();
        getAnswer(input);
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    congratulate();
                } else {
                    return 1;
                }
            } else {
                getIncorrectAnswer(input, result);
            }
        }
        return 0;
    }

    public static boolean getParityResult(int evenNum) {
        return evenNum % 2 == 0;
    }

    public static boolean getIsSimple(Integer number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String parsResult(String result) {
        return switch (result) {
            case "true" -> "yes";
            case "false" -> "no";
            default -> throw new Error("Unknown result!");
        };
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

    public static int getNumGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getNumGCD(b, a % b);
        }
    }
}

