package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Utils.getRandomInt;

public class Engine {
    private static final int MIN_NUMBER = 5;
    private static final int BOUND_LENGTH = 6;
    private static final int STEP_START = 1;
    private static final int BOUND_STEP = 25;
    private static final int BOUND_START = 101;
    private static final int BOUND_SIGN = 2;
    private static final int MIN_SIGN = 0;
    private static String playerName;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void greetings() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        greetings1();
    }

    public static void greetings1() {
        String name = getString();
        System.out.print("Hello, " + name + "!\n");
        playerName = name;
    }

    public static void askQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static String getString() {
        return SCANNER.nextLine();
    }

    public static void getAnswer(String answer) {
        System.out.println("Your answer: " + answer);
    }

    public static void congratulate() {
        System.out.println("Congratulations, " + playerName + "!");
        System.exit(0);
    }

    public static void getIncorrectAnswer(String input, String result) {
        System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
        System.out.println("'" + result + "'");
        System.out.println("Let's try again, " + playerName + "!");
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

    public static String[] generateQuestionForProgression() {
        int[] progression = generateProgression();
        int hiddenIndex = getRandomInt(progression.length, 0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i != hiddenIndex) {
                stringBuilder.append(progression[i]).append(" ");
            } else {
                stringBuilder.append(".. ");
            }
        }
        String result1 = stringBuilder.toString().trim();
        String result2 = String.valueOf(progression[hiddenIndex]);
        return new String[]{result1, result2};
    }

    public static int[] generateProgression() {
        int length = getRandomInt(BOUND_LENGTH, MIN_NUMBER); // Генерация случайной длины от 5 до 10
        int[] progression = new int[length];
        int start = getRandomInt(BOUND_START, MIN_NUMBER); // Генерация случайного начального числа
        int step = getRandomInt(BOUND_STEP, STEP_START); // Генерация шага
        for (int i = 0; i < length; i++) {
            progression[i] = start + (i * step); // Шаг арифметической прогрессии равен step
        }
        return progression;
    }
}

