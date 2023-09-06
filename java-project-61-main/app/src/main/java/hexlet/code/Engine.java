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
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        greet1();
    }

    public static void greet1() {
        String name = Generate.nameS();
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
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        if (inputNum == 1) {
            Greet.gameStart();
            Engine.gameEngine();
        } else if (inputNum == 2) {
            greet();
            Even.gameStart();
        } else if (inputNum == 3) {
            greet();
            Calc.gameStart();
        } else if (inputNum == 4) {
            greet();
            GSD.gameStart();
        } else if (inputNum == 5) {
            greet();
            Progression.gameStart();
        } else if (inputNum == 6) {
            greet();
            Prime.gameStart();
        } else if (inputNum == 0) {
            System.out.println("\nBay!");
            System.exit(0);
        } else {
            Engine.gameEngine();
        }
    }
}


