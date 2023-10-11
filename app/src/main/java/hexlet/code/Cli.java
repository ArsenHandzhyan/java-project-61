package hexlet.code;

import static hexlet.code.Utils.getString;

public class Cli {

    public static void greeting() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = getString();
        System.out.println("Hello, " + userName + "!");
    }
}
