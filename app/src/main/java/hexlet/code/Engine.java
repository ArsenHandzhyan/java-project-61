package hexlet.code;

import java.util.Scanner;
import java.util.function.Supplier;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String playerName;

    public static void runGameRounds(String description,
                                     Supplier<String[]> generateRoundData) {
        String[] round1 = generateRoundData.get();
        String[] round2 = generateRoundData.get();
        String[] round3 = generateRoundData.get();
        String[][] roundsData = {round1, round2, round3};
        run(description, roundsData, 0);
    }

    public static void run(String description, String[][] roundsData, int count) {
        String result = roundsData[count][0];
        String questions = roundsData[count][1];
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
        String consoleInput = SCANNER.nextLine();
        System.out.println("Your answer: " + consoleInput);
        if (consoleInput.equals(result)) {
            printCorrectAnswer(count);
            if (count < 2) {
                run(description, roundsData, ++count);
            }
        } else {
            printIncorrectAnswer(consoleInput, result);
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
