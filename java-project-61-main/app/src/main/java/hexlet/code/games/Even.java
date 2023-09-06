package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Generate;

import java.util.Scanner;

public class Even {
    static Scanner sc = new Scanner(System.in);

    public static void gameStart() {
        System.out.println("\nAnswer 'yes' if the number is even, otherwise answer 'no'.");
        game(0);
    }


    public static String evenNumber(int evenNum) {
        if (evenNum % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static void game(int count) {
        int evenNum = Generate.randomGen(101) + 1;
        System.out.println("Question: " + evenNum);
        String input = sc.nextLine();
        String even = evenNumber(evenNum);
        if (count <= 2) {
            if (input.equals(even)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    Engine.gameEngine();
                } else {
                    game(++count);
                }
            } else {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.");
                Engine.again();
                Engine.gameEngine();
            }
        } else {
            Engine.gameEngine();
        }
    }
}

