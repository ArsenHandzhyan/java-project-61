package hexlet.code;

import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GSD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine implements Generate {

    public static void greet() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name?  ");
        greet1();
    }

    public static void greet1() {
        String name = Generate.nameS();
        System.out.println("Hello, " + name + "!");
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
        try (Scanner sc = new Scanner(System.in)) {
            String inputNum = sc.nextLine();
            switch (inputNum) {
                case "1" -> {
                    Greet.gameStart();
                    Engine.gameEngine();
                }
                case "2" -> {
                    greet();
                    Even.gameStart();
                }
                case "3" -> {
                    greet();
                    Calc.gameStart();
                }
                case "4" -> {
                    greet();
                    GSD.gameStart();
                }
                case "5" -> {
                    greet();
                    Progression.gameStart();
                }
                case "6" -> {
                    greet();
                    Prime.gameStart();
                }
                case "0" -> {
                    System.out.println("\nBay!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("input invalid enter \"0\" - \"6\"");
                    Engine.gameEngine();
                }
            }
        }
    }
}


