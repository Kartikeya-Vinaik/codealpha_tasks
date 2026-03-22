import java.util.*;

public class Booking {
    private static int counter = 1;
    private int bookingId;
    private Customer customer;
    private Room room;
    private String status;

    public Booking(Customer customer, Room room) {
        this.bookingId = counter++;
        this.customer = customer;
        this.room = room;
        this.status = "CONFIRMED";
    }

    public Booking(int id, Customer customer, Room room, String status) {
        this.bookingId = id;
        this.customer = customer;
        this.room = room;
        this.status = status;
    }

    public static void updateCounter(ArrayList<Booking> bookings) {
        int max = 0;
        for (Booking b : bookings) {
            if (b.bookingId > max) max = b.bookingId;
        }
        counter = max + 1;
    }

    public int getBookingId() { return bookingId; }
    public Room getRoom() { return room; }
    public String getStatus() { return status; }
    public void cancelBooking() { status = "CANCELLED"; }

    public String toFileString() {
        return bookingId + "," + customer.getName() + "," + customer.getPhoneNumber() + "," + room.getRoomNumber() + "," + status;
    }

    public String toString() {
        return "ID: " + bookingId + " | Name: " + customer.getName() + " | Room: " + room.getRoomNumber() + " | Type: " + room.getRoomType() + " | Status: " + status;
    }
}
