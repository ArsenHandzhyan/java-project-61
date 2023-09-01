package hexlet.code;

import java.util.Scanner;

public class Greet {
    public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");
        App.main(null);
    }
}
