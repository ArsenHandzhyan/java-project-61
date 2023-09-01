package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    static Scanner sc = new Scanner(System.in);
    public static String name = sc.nextLine();
    static int count = 0;

    public static void gameStart1() {
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        game();
    }

    public static int randomGen() {
        Random random = new Random();
        return random.nextInt(101);
    }

    public static String evenNumber(int evenNum) {
        if (evenNum % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void game() {
        int evenNum = randomGen();
        System.out.println("Question: " + evenNum);
        String input = sc.nextLine();
        String even = evenNumber(evenNum);
        if (count < 2) {
            if (input.equals(even)) {
                System.out.println("Correct!");
                count++;
                game();
            } else {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                System.out.println("Let's try again, " + name + " !");
            }
        } else {
            System.out.println("Congratulations, " + name + " !");
        }
    }
}

