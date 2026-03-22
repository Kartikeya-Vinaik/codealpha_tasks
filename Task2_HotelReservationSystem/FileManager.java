import java.io.*;
import java.util.*;

public class FileManager {
    private final String FILE_NAME = "bookings.txt";

    public void saveBookings(ArrayList<Booking> bookings) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Booking b : bookings) {
                bw.write(b.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data!");
        }
    }

    public ArrayList<Booking> loadBookings(ArrayList<Room> rooms) {
        ArrayList<Booking> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String phone = data[2];
                int roomNo = Integer.parseInt(data[3]);
                String status = data[4];

                Room room = null;
                for (Room r : rooms) {
                    if (r.getRoomNumber() == roomNo) {
                        room = r;
                        if (status.equals("CONFIRMED")) r.setAvailable(false);
                    }
                }

                Customer customer = new Customer(name, phone);
                Booking booking = new Booking(id, customer, room, status);
                list.add(booking);
            }
        } catch (IOException e) {
            System.out.println("Error loading data!");
        }
        return list;
    }
}
