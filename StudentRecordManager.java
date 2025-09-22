import java.io.*;
import java.util.*;

public class StudentRecordManager {

    static final String FILE_NAME = "students.txt";

    // 1. Add a new student record (append)
    public static void addStudent(String rollNo, String name, String dept) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(rollNo + "," + name + "," + dept);
            bw.newLine();
            System.out.println("Student record added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // 2. Read all student records
    public static void readStudents() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nStudent Records:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    System.out.println("Roll No: " + parts[0] + ", Name: " + parts[1] + ", Dept: " + parts[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // 3. Update an existing student record
    public static void updateStudent(String rollNo, String newName, String newDept) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp_students.txt");

        boolean found = false;

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(rollNo)) {
                    writer.write(rollNo + "," + newName + "," + newDept);
                    found = true;
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error during file processing: " + e.getMessage());
            return;
        }

        if (!found) {
            tempFile.delete();
            System.out.println("Student with Roll No " + rollNo + " not found.");
            return;
        }

        // Replace old file with updated file
        if (!inputFile.delete()) {
            System.out.println("Error: Could not delete original file.");
            return;
        }

        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Error: Could not rename temp file to original.");
            return;
        }

        System.out.println("Record updated successfully.");
    }

    // 4. Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Record Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    addStudent(roll, name, dept);
                    break;

                case 2:
                    readStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to Update: ");
                    String rollToUpdate = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();
                    updateStudent(rollToUpdate, newName, newDept);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
