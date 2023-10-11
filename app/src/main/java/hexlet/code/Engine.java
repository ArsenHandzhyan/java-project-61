package hexlet.code;

import static hexlet.code.Utils.getString;

public class Engine {
    private static String playerName;

    public static void run(String description, String[][] roundsData, int countNewGame) {
        String result = roundsData[countNewGame][0];
        String questions = roundsData[countNewGame][1];
        String countS = roundsData[countNewGame][2];
        int count = Integer.parseInt(countS);
        if (count == 0) {
            getGreet(description);
        }
        System.out.println("Question: " + questions);
        String input = getString();
        System.out.println("Your answer: " + input);
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    System.out.println("Congratulations, " + playerName + "!\n");
                } else {
                    ++count;
                    run(description, roundsData, count);
                }
            } else {
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println("'" + result + "'");
                System.out.println("Let's try again, " + playerName + "!");
            }
        }
    }

    public static void getGreet(String description) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = getString();
        System.out.print("Hello, " + name + "!\n");
        playerName = name;
        System.out.println(description);
    }
}

