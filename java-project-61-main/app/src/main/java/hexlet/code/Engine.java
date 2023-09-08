package hexlet.code;

import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GSD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String string() {
        String name = SCANNER.nextLine();
        return name;
    }

    public static int randomGen(int bound) {
        return new Random().nextInt(bound);
    }

    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        greet1();
    }

    public static void greet1() {
        String name = string();
        System.out.println("Hello, " + name + "!\n");
        name1 = name;
    }

    static String name1;

    public static void again() {
        System.out.println("Let's try again, " + name1 + " !");
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + name1 + " !");
    }

    public static void gameEngine() {
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
        String input = string();

        switch (input) {
            case "1" -> {
                Greet.gameStart();
                gameEngine();
            }
            case "2" -> {
                greet();
                Even.gameStart();
                gameEngine();
            }
            case "3" -> {
                greet();
                Calc.gameStart();
                gameEngine();
            }
            case "4" -> {
                greet();
                GSD.gameStart();
                gameEngine();
            }
            case "5" -> {
                greet();
                Progression.gameStart();
                gameEngine();
            }
            case "6" -> {
                greet();
                Prime.gameStart();
                gameEngine();
            }
            case "0" -> {
                System.out.println("\nBay!");
                System.exit(0);
            }
            default -> {
                System.out.println("You entered an invalid value: from 1 to 6 to select a game and 0 to exit!\n");
                gameEngine();
            }
        }
    }
}
