package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Generate;

import java.util.Random;
import java.util.Scanner;

public class GSD implements Generate {

    static Scanner sc = new Scanner(System.in);

    public static void gameStart1() {
        System.out.println("Find the greatest common divisor of given numbers.");
        game(0);
    }

    public static void game(int count) {
        Random rand = new Random(20);
        int gcd = rand.nextInt(50); // Ограничение общего делителя от 1 до 50

        // Генерируем вспомогательные множители для чисел
        int multiplier1 = Generate.randomGen();
        int multiplier2 = Generate.randomGen();

        // Рассчитываем числа с учетом общего делителя
        int num1 = gcd * multiplier1;
        int num2 = gcd * multiplier2;
        String expression = num1 + " " + num2;
        String result = Integer.toString(findGCD(num1, num2));

        System.out.println("Question: " + expression);

        String input = sc.nextLine();

        if (count <= 2) {
            if (result.equals(input)) {
                System.out.println("Correct!");
                if (count == 2) {
                    Engine.congratulations();
                    Engine.gameEngine();
                } else {
                    game(++count);
                }
            } else {
                System.out.println("Your answer: " + input);
                System.out.println("'" + input + "'" + "is wrong answer ;(. Correct answer was" + "'" + result + "'");
                Engine.again();
                Engine.gameEngine();
            }
        } else {
            Engine.gameEngine();
        }
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }
}

