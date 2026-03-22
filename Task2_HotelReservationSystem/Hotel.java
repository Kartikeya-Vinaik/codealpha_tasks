import java.util.*;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private FileManager fileManager = new FileManager();

    public Hotel() {
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Standard", 1000, true));
        rooms.add(new Room(102, "Standard", 1000, true));
        rooms.add(new Room(201, "Deluxe", 2000, true));
        rooms.add(new Room(202, "Deluxe", 2000, true));
        rooms.add(new Room(301, "Suite", 4000, true));
    }

    public void searchRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (r.isAvailable()) {
                System.out.println(r);
            }
        }
    }

    public void bookRoom(Scanner sc) {
        try {
            System.out.print("Enter Room Number: ");
            int roomNo = Integer.parseInt(sc.nextLine());

            Room selected = null;
            for (Room r : rooms) {
                if (r.getRoomNumber() == roomNo && r.isAvailable()) {
                    selected = r;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Room not available!");
                return;
            }

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Phone (10 digits): ");
            String phone = sc.nextLine();

            if (!phone.matches("\\d{10}")) {
                System.out.println("Invalid phone number!");
                return;
            }

            Customer customer = new Customer(name, phone);
            Payment payment = new Payment();

            if (payment.processPayment(selected.getPrice(), sc)) {
                Booking booking = new Booking(customer, selected);
                bookings.add(booking);
                selected.setAvailable(false);

                System.out.println("Booking Confirmed! ID: " + booking.getBookingId());
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    public void cancelBooking(Scanner sc) {
        try {
            System.out.print("Enter Booking ID: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Booking b : bookings) {
                if (b.getBookingId() == id && b.getStatus().equals("CONFIRMED")) {
                    b.cancelBooking();
                    b.getRoom().setAvailable(true);
                    System.out.println("Booking Cancelled!");
                    return;
                }
            }

            System.out.println("Invalid Booking ID!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
        }
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    public void saveData() {
        fileManager.saveBookings(bookings);
    }

    public void loadData() {
        bookings = fileManager.loadBookings(rooms);
        Booking.updateCounter(bookings);
    }
}
