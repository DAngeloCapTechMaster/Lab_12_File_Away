import javax.swing.*;
import java.io.*;

public class FileInspector {
    public static void main(String[] args) {
        // Create the file chooser
        JFileChooser fileChooser = new JFileChooser("src");

        // Show the open dialog
        int returnValue = fileChooser.showOpenDialog(null);

        // Check if the user selected a file
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File chosen: " + selectedFile.getAbsolutePath());

            // Read and print the file's content
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
