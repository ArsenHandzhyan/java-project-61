package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import static hexlet.code.Engine.getString;
import static hexlet.code.Engine.greetings;

public class App {
    public static void main(String[] args) {
        System.out.print("""
                Please enter the game number and press Enter:
                1 - Greet
                2 - Even
                3 - Calc
                4 - GSD
                5 - Progression
                6 - Prime
                0 - Exit
                """);
        System.out.print("Your choice: ");
        String input = getString();

        switch (input) {
            case "1" -> Cli.greeting();
            case "2" -> {
                greetings();
                Even.gameStart();
            }
            case "3" -> {
                greetings();
                Calc.gameStart();
            }
            case "4" -> {
                greetings();
                GCD.gameStart();
            }
            case "5" -> {
                greetings();
                Progression.gameStart();
            }
            case "6" -> {
                greetings();
                Prime.gameStart();
            }
            case "0" -> {
                System.out.println("\nBay!");
                System.exit(0);
            }
            default ->
                    System.out.println("You entered an invalid value: from 1 to 6 to select a game and 0 to exit!\n");
        }
    }
}
