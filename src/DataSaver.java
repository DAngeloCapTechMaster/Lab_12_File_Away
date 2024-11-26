import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // ArrayList to store the CSV records
        ArrayList<String> records = new ArrayList<>();

        // Loop to collect user data
        boolean addMore = true;
        while (addMore) {
            System.out.println("Enter the following details:");

            // Collect user input
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("ID Number (6 digits, e.g., 000001): ");
            String idNumber = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Year of Birth (4 digits): ");
            String yearOfBirth = scanner.nextLine();

            // Create a CSV record
            String record = String.join(",", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            // Ask the user if they want to add another record
            System.out.print("Do you want to add another record? (yes/no): ");
            addMore = scanner.nextLine().equalsIgnoreCase("yes");
        }

        // Prompt the user for the file name
        System.out.print("Enter the name of the CSV file to save the data (e.g., records.csv): ");
        String fileName = scanner.nextLine();

        // Save the records to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine(); // Move to the next line
            }
            System.out.println("Data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file: " + e.getMessage());
        }

        // Close the scanner
        scanner.close();
    }
}
