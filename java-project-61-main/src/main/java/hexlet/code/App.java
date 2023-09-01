package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n" + "2 - Even");
        System.out.println("0 - Exit");
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        if (inputNum == 1) {
            System.out.println("Your choice: 1");
            Greet.greetUser();
        } else if (inputNum == 2) {
            System.out.println("Your choice: 2");
            System.out.println("Welcome to the Brain Games!");
            System.out.println("May I have your name?");
            Even.gameStart1();
        } else if (inputNum == 0) {
            System.out.println("Bay!");
        } else {
            App.main(null);
        }
    }
}
