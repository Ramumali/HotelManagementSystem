package HotelManagemetSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Main {
    // 2-D Array 10 floors, 26 rooms (A to Z)
    static String[][] hotel = new String[10][26];
    static int coinsCollected = 0;  // coins or rent for each room booked
    static Map<String, String> bookings = new HashMap<>();  // Rooms booked and avilable List

    // Method to PrintRooms
    public static void printRooms() {
        for (int floor = 0; floor < hotel.length; floor++) {
            for (int room = 0; room < hotel[floor].length; room++) {
                char roomChar = (char) ('A' + room);
                String roomNumber = floor + "" + roomChar;
                if (bookings.containsKey(roomNumber)) {
                    System.out.print(roomNumber + "(Booked) ");
                } else {
                    System.out.print(roomNumber + "(Available) ");
                }
            }
            System.out.println();
        }
    }

    // Method to book a room
    public static void bookRoom(String roomNumber, String customerName) {
        // Check if the room is already booked by other customer
        if (bookings.containsKey(roomNumber)) {
            System.out.println("Room " + roomNumber + " is already booked.");
        } else {
            bookings.put(roomNumber, customerName);
            coinsCollected++;
            System.out.println("Room " + roomNumber + " is booked by " + customerName);
        }
    }

    // Method to checkout a customer
    public static void checkoutCustomer(String customerName) {
        for (Map.Entry<String, String> entry : bookings.entrySet()) {
            if (entry.getValue().equals(customerName)) {
                bookings.remove(entry.getKey());
                System.out.println("Customer " + customerName + " has checked out the room " + entry.getKey());
                return;
            }
        }
        // If customer is not found or details entered mistakenly
        System.out.println("Customer " + customerName + " not found.");
    }

    // Method to get total coins collected
    public static int getTotalCoinsCollected() {
        return coinsCollected;
    }

    // Method to get total active bookings
    public static int getTotalActiveBookings() {
        return bookings.size();
    }

    // Method to print booked rooms and customer names
    public static void printBookedRooms() {
        if (bookings.isEmpty()) {
            System.out.println("No rooms are currently booked.");
        } else {
            for (Map.Entry<String, String> entry : bookings.entrySet()) {
                System.out.println("Room " + entry.getKey() + " is booked by " + entry.getValue());
            }
        }
    }

    // Method to get the room number of a customer
    public static String getRoomNumber(String customerName) {
        for (Map.Entry<String, String> entry : bookings.entrySet()) {
            if (entry.getValue().equals(customerName)) {
                return entry.getKey();
            }
        }
        return "Customer not found.";
    }

    // Method to get the customer name for a room number
    public static String getCustomerName(String roomNumber) {
        if (bookings.containsKey(roomNumber)) {
            return bookings.get(roomNumber);
        } else {
            return "Room " + roomNumber + " is not booked.";
        }
    }

    // Main Method and it is the entry point of the program.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to my Ramanathan's Hotel Booking Management System!!! :)");

        System.out.println("Are You want to proceed ?: (Yes/No): ");

        List<String> validResponses = Arrays.asList("yes", "ok", "sure","yeah");

        String userResponse = scanner.nextLine().toLowerCase();

        if (validResponses.contains(userResponse)){

            do {
                System.out.println("\nChoose an option:");
                System.out.println("1. Book a room");
                System.out.println("2. Checkout a room");
                System.out.println("3. Display total coins collected");
                System.out.println("4. Display total active bookings");
                System.out.println("5. Print total booked rooms");
                System.out.println("6. Find room by customer name");
                System.out.println("7. Find customer by room number");
                System.out.println("8. Display all rooms");
                System.out.println("9. Exit");
    
                input = scanner.next();
    
                switch (input) {
                    case "1": 
                        System.out.print("Enter room number (For example: 1B): ");
                        String roomNumber = scanner.next();
                        System.out.print("Enter customer name: ");
                        String customerName = scanner.next();
                        bookRoom(roomNumber, customerName);
                        break;
                    case "2": 
                        System.out.print("Enter customer name to checkout: ");
                        String customer = scanner.next();
                        checkoutCustomer(customer);
                        break;
                    case "3":  
                        System.out.println("Total coins collected: " + getTotalCoinsCollected());
                        break;
                    case "4":  
                        System.out.println("Total active bookings: " + getTotalActiveBookings());
                        break;
                    case "5": 
                        printBookedRooms();
                        break;
                    case "6": 
                        System.out.print("Enter customer name: ");
                        String customerToFind = scanner.next();
                        System.out.println("Room: " + getRoomNumber(customerToFind));
                        break;
                    case "7":
                        System.out.print("Enter room number: ");
                        String roomToFind = scanner.next();
                        System.out.println("Customer: " + getCustomerName(roomToFind));
                        break;
                    case "8": 
                        printRooms();
                        break;
                    case "9":
                        System.out.println("Goodbye!!!. Have a Nice Day :)");
                        break;
                    default:
                        System.out.println("Invalid option! Please try again.");
                        break;
                }
            } while (!input.equals("9"));

        }

        else{
            System.out.println("Thank for visiting and Bye");
        }

        

        scanner.close();
    }
}
