import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {

    public static int getIntInput(Scanner scanner, String prompt) {

        while (true) {

            try {
                System.out.print(prompt);
                return scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {

        while (true) {

            try {
                System.out.print(prompt);
                return scanner.nextDouble();

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }
}