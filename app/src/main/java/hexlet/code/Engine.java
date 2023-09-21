package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static String name1;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void greetings() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        greetings1();
    }

    public static void greetings1() {
        String name = getString();
        System.out.print("Hello, " + name + "!\n");
        name1 = name;
    }

    public static String getString() {
        return SCANNER.nextLine();
    }

    public static void getAnswer(String input) {
        System.out.println("Your answer: " + input);
    }

    public static void congratulate() {
        System.out.println("Congratulations, " + name1 + "!");
        System.exit(0);
    }

    public static void getIncorrectAnswer(String input, String result) {
        System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
        System.out.println("'" + result + "'");
        System.out.println("Let's try again, " + name1 + "!");
    }

    public static int randomGen(int bound) {
        return new Random().nextInt(bound);
    }

}

