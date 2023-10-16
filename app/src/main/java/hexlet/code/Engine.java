package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int RESULT_INDEX = 0;
    private static final int ANSWER_INDEX = 1;
    private static String playerName;


    public static void run(String description, String[][] roundsData) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = SCANNER.nextLine();
        System.out.print("\nHello, " + playerName + "!\n");
        System.out.println(description);
        for (String[] roundData : roundsData) {
            String result = roundData[RESULT_INDEX];
            String answer = roundData[ANSWER_INDEX];
            System.out.println("Question: " + answer);
            System.out.print("Your answer: ");
            String input = SCANNER.nextLine();
            if (input.equals(result)) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println("'" + result + "'");
                System.out.println("Let's try again, " + playerName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + playerName + "!\n");
    }
}
