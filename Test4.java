import java.io.*;
import java.util.Scanner;

public class Test4 {
    private static final String FILE_NAME = "notes.txt";


    public static void writeNotes(String note) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + "\n");
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }


    public static void readNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nYour Notes:");
            boolean empty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                empty = false;
            }
            if (empty) {
                System.out.println("No notes found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Start writing!");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }


    public static void deleteNotes() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) { 

            System.out.println("All notes deleted successfully!");
        } catch (IOException e) {
            System.out.println("Error deleting notes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Notes App ===");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Delete All Notes");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    writeNotes(note);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    deleteNotes();
                    break;
                case 4:
                    System.out.println("Exiting Notes App. Bye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
