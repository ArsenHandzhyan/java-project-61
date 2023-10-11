package hexlet.code;

import static hexlet.code.Utils.getString;

public class Engine {
    private static String playerName;
    private static final int COUNT_INDEX = 2;
    private static final int QUESTIONS_INDEX = 1;
    private static final int RESULT_INDEX = 0;

    public static void run(String description, String[][] roundsData, int countGame) {
        int count = countGame;
        String countS = roundsData[count][COUNT_INDEX];
        count = Integer.parseInt(countS);
        String result = roundsData[count][RESULT_INDEX];
        String questions = roundsData[count][QUESTIONS_INDEX];
        if (count == 0) {
            System.out.println("\nWelcome to the Brain Games!");
            System.out.print("May I have your name? ");
            String name = getString();
            System.out.print("Hello, " + name + "!\n");
            playerName = name;
            System.out.println(description);
        }
        System.out.println("Question: " + questions);
        String input = getString();
        System.out.println("Your answer: " + input);
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    System.out.println("Congratulations, " + playerName + "!\n");
                    App.main(null);
                } else {
                    ++count;
                    run(description, roundsData, count);
                }
            } else {
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println("'" + result + "'");
                System.out.println("Let's try again, " + playerName + "!");
                App.main(null);
            }
        }
    }
}


