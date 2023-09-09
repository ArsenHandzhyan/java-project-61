package hexlet.code;

import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GSD;
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
        String name = SCANNER.nextLine();
        return name;
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
                gameEngine();
            }
        }
        if (count <= 2) {
            if (input.equals(result)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    Engine.gameEngine();
                } else {
                    switch (game) {
                        case 2 -> {
                            Even.newGame(++count);
                        }
                        case 3 -> {
                            Calc.newGame(++count);
                        }
                        case 4 -> {
                            GSD.newGame(++count);
                        }
                        case 5 -> {
                            Progression.newGame(++count);
                        }
                        case 6 -> {
                            Prime.newGame(++count);
                        }
                        default -> {
                            gameEngine();
                        }
                    }
                }
            } else {
                System.out.print("'" + input + "'" + "is wrong answer ;(. Correct answer was");
                System.out.println("'" + result + "'");
                Engine.again();
                Engine.gameEngine();
            }
        } else {
            Engine.gameEngine();
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

    public static void gameEngine() {
        System.out.print("""
                Please enter the game number and press Enter:
                1 - Greet
                2 - Even
                3 - Calc
                4 - GSD
                5 - Progression
                6 - Prime
                0 - Exit
                """);
        System.out.print("Your choice: ");
        String input = string();

        switch (input) {
            case "1" -> {
                Greet.gameStart();
                gameEngine();
            }
            case "2" -> {
                greetings();
                Even.gameStart();
                gameEngine();
            }
            case "3" -> {
                greetings();
                Calc.gameStart();
                gameEngine();
            }
            case "4" -> {
                greetings();
                GSD.gameStart();
                gameEngine();
            }
            case "5" -> {
                greetings();
                Progression.gameStart();
                gameEngine();
            }
            case "6" -> {
                greetings();
                Prime.gameStart();
                gameEngine();
            }
            case "0" -> {
                System.out.println("\nBay!");
                System.exit(0);
            }
            default -> {
                System.out.println("You entered an invalid value: from 1 to 6 to select a game and 0 to exit!\n");
                gameEngine();
            }
        }
    }
}
