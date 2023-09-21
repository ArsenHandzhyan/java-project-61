package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.randomGen;

public class Prime {
    private static final int MIN_NUMBER = 1;
    private static final int BOUND = 501;

    public static void gameStart() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        newGame(0);
    }

    public static void newGame(int count) {
        int results = randomGen(BOUND) + MIN_NUMBER;
        String number = Integer.toString(results);
        boolean correctAnswer = isSimple(results);
        String result = String.valueOf(correctAnswer);
        System.out.println("Question: " + number);
        play(count, result);
    }

    public static void play(int count, String result) {
        String input = Engine.getString();
        Engine.getAnswer(input);
        if (input.equals("yes")) {
            input = "true";
        } else if (input.equals("no")) {
            input = "false";
        } else {
            System.out.println("input invalid enter \"yes\" or \"no\"");
            System.exit(0);
        }
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulate();
                    System.exit(0);
                } else {
                    newGame(++count);
                }
            } else {
                Engine.getIncorrectAnswer(input, result);
                System.exit(0);
            }
        } else {
            System.exit(0);
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
