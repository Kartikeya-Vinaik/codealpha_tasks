import java.util.*;

public class Payment {
    public boolean processPayment(double amount, Scanner sc) {
        System.out.println("Amount to pay: Rs." + amount);
        System.out.println("Select Payment Method:");
        System.out.println("1. UPI\n2. Card\n3. Cash");
        System.out.print("Choice: ");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid payment method!");
            return false;
        }

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid option!");
            return false;
        }

        System.out.println("Processing payment...");
        System.out.println("Payment Successful!");
        return true;
    }
}
