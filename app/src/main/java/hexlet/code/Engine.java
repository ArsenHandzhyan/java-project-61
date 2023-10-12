package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String playerName;

    public static void run(String description, String[][] roundsData, int countNewGame) {
        String result = roundsData[countNewGame][0];
        String questions = roundsData[countNewGame][1];
        int count = Integer.parseInt(roundsData[countNewGame][2]);

        if (count == 0) {
            getGreet(description);
            printQuestion(questions);
            checkAnswerAndGetInput(result, count, description, roundsData);
        } else if (count <= 2) {
            printQuestion(questions);
            checkAnswerAndGetInput(result, count, description, roundsData);
        }
    }

    private static void printQuestion(String question) {
        System.out.println("Question: " + question);
    }

    private static void checkAnswerAndGetInput(String result, int count, String description, String[][] roundsData) {
        String input = SCANNER.nextLine();
        System.out.println("Your answer: " + input);

        if (input.equals(result)) {
            printCorrectAnswer(count);
            if (count < 2) {
                run(description, roundsData, ++count);
            }
        } else {
            printIncorrectAnswer(input, result);
        }
    }

    private static void printCorrectAnswer(int count) {
        System.out.println("Correct!");
        if (count == 2) {
            System.out.println("Congratulations, " + playerName + "!\n");
        }
    }

    private static void printIncorrectAnswer(String input, String result) {
        System.out.print("'" + input + "'" + " is wrong answer ;(. Correct answer was");
        System.out.println("'" + result + "'");
        System.out.println("Let's try again, " + playerName + "!");
    }

    public static void getGreet(String description) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        playerName = SCANNER.nextLine();
        System.out.print("Hello, " + playerName + "!\n");
        System.out.println(description);
    }
}
