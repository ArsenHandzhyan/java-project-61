package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GSD;
import hexlet.code.games.Progression;


import java.util.Scanner;

public class Engine implements Generate {


    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
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
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" + "2 - Even\n" + "3 - Calc");
        System.out.println("4 - GSD\n" + "5 - Progression\n" + "0 - Exit");
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        if (inputNum == 1) {
            System.out.println("Your choice: 1\n");
            for (int count = 0; count <= 2; count++) {
                greet();
            }
            Engine.gameEngine();
        } else if (inputNum == 2) {
            System.out.println("Your choice: 2\n");
            greet();
            Even.gameStart1();
        } else if (inputNum == 3) {
            System.out.println("Your choice: 3\n");
            greet();
            Calc.gameStart1();
        } else if (inputNum == 4) {
            System.out.println("Your choice: 4\n");
            greet();
            GSD.gameStart1();
        } else if (inputNum == 5) {
            System.out.println("Your choice: 5\n");
            greet();
            Progression.gameStart1();
        } else if (inputNum == 0) {
            System.out.println("Bay!");
        } else {
            Engine.gameEngine();
        }
    }
}


