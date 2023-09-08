package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.randomGen;
import static hexlet.code.Engine.string;

public class Prime {

    public static void gameStart() {
        System.out.println("\nAnswer 'yes' if given number is prime. Otherwise answer 'no'.");
        game(0);
    }

    public static void game(int count) {
        int results = randomGen(501) + 1;
        String result = Integer.toString(results);
        boolean correctAnswer = isSimple(results);
        String correctAnswerString = String.valueOf(correctAnswer);
        System.out.println("Question: " + result);
        String input = string();
        if (input.equals("yes")) {
            input = "true";
        } else if (input.equals("no")) {
            input = "false";
        } else {
            System.out.println("input invalid enter \"yes\" or \"no\"");
            Engine.gameEngine();
        }

        if (count <= 2) {
            if (input.equals(correctAnswerString)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    Engine.gameEngine();
                } else {
                    game(++count);
                }
            } else {
                System.out.println("Your answer: " + input);
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println("'" + correctAnswerString + "'");
                Engine.again();
                Engine.gameEngine();
            }
        } else {
            Engine.gameEngine();
        }
    }

    public static boolean isSimple(Integer number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
