public class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String roomType, double price, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    public String toString() {
        return "Room: " + roomNumber + " | " + roomType + " | Rs." + price + " | Available: " + isAvailable;
    }
}
