package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    static String consoleInput;
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
        consoleInput = scanner.nextLine();
        switch (consoleInput) {
            case "1" -> Cli.greeting();
            case "2" -> Even.startPlay();
            case "3" -> Calc.startPlay();
            case "4" -> GCD.startPlay();
            case "5" -> Progression.startPlay();
            case "6" -> Prime.startPlay();
            case "0" -> System.out.println("\nBay!");
            default -> System.out.println("You entered an invalid value: from 1 to "
                    + "6 to select a game and 0 to exit!\n");
        }
    }
}