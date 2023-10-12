package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);
    static String playerName;

    public static void greeting() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = SCANNER.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }
}
