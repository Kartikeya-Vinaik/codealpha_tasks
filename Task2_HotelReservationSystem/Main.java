import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();
        hotel.loadData();

        while (true) {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {
                case 1: hotel.searchRooms(); break;
                case 2: hotel.bookRoom(sc); break;
                case 3: hotel.cancelBooking(sc); break;
                case 4: hotel.viewBookings(); break;
                case 5:
                    hotel.saveData();
                    System.out.println("Exiting...");
                    return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
