package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import static hexlet.code.Utils.getString;

public class Engine {
    private static String playerName;

    public static void run(String description, String[] roundsData) {
        String result = roundsData[0];
        String questions = roundsData[1];
        String gameNumber = roundsData[2];
        String countS = roundsData[3];
        int count = Integer.parseInt(countS);
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
                    switch (gameNumber) {
                        case "1" -> Cli.greeting();
                        case "2" -> Even.startPlay(++count);
                        case "3" -> Calc.startPlay(++count);
                        case "4" -> GCD.startPlay(++count);
                        case "5" -> Progression.startPlay(++count);
                        case "6" -> Prime.startPlay(++count);
                        default -> System.out.println("Unknown gameNumbers");
                    }
                }
            } else {
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println("'" + result + "'");
                System.out.println("Let's try again, " + playerName + "!");
                App.main(null);
            }
        } else {
            App.main(null);
        }
    }
}

