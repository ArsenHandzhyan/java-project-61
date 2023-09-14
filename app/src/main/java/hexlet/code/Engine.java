package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void greetings() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        greetings1();
    }

    public static void greetings1() {
        String name = string();
        System.out.print("Hello, " + name + "!\n");
        name1 = name;
    }

    public static String string() {
        return SCANNER.nextLine();
    }

    public static void game(int count, String result, int game) {
        String input = string();
        System.out.println("Your answer: " + input);
        if (game == 6) {
            if (input.equals("yes")) {
                input = "true";
            } else if (input.equals("no")) {
                input = "false";
            } else {
                System.out.println("input invalid enter \"yes\" or \"no\"");
                App.main(null);
            }
        }
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    System.exit(0);
                } else {
                    switch (game) {
                        case 2 -> Even.newGame(++count);
                        case 3 -> Calc.newGame(++count);
                        case 4 -> GCD.newGame(++count);
                        case 5 -> Progression.newGame(++count);
                        case 6 -> Prime.newGame(++count);
                        default -> App.main(null);
                    }
                }
            } else {
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println("'" + result + "'");
                Engine.again();
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    public static int randomGen(int bound) {
        return new Random().nextInt(bound);
    }

    static String name1;

    public static void again() {
        System.out.println("Let's try again, " + name1 + "!");
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + name1 + "!");
    }
}

