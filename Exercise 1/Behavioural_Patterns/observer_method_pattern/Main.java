import src.PlacementDrive;
import src.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        PlacementDrive drive = new PlacementDrive();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        LOG.info("Placement Drive System started.");

        while (running) {
            System.out.println("\n===== Placement Drive Menu =====");
            System.out.println("1. Register Student");
            System.out.println("2. Unregister Student");
            System.out.println("3. Announce Drive");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice;
            try {
                choice = scanner.nextLine().trim();
            } catch (Exception e) {
                LOG.warning("Input error or EOF detected. Exiting.");
                break;
            }

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine().trim();
                    try {
                        drive.register(new Student(name));
                        LOG.info("Student registered: " + name);
                    } catch (IllegalArgumentException e) {
                        LOG.warning("Registration failed: " + e.getMessage());
                    }
                }
                case "2" -> {
                    System.out.print("Enter student name to remove: ");
                    String name = scanner.nextLine().trim();
                    boolean removed = drive.unregister(name);
                    if (removed) {
                        LOG.info("Student unregistered: " + name);
                    } else {
                        LOG.warning("No student found with name: " + name);
                    }
                }
                case "3" -> {
                    System.out.print("Enter company name: ");
                    String company = scanner.nextLine().trim();
                    System.out.print("Enter student names to notify (comma-separated, or press Enter for all): ");
                    String studentsInput = scanner.nextLine().trim();
                    List<String> studentNames = null;
                    if (!studentsInput.isEmpty()) {
                        studentNames = Arrays.stream(studentsInput.split(","))
                            .map(String::trim)
                            .filter(s -> !s.isEmpty())
                            .collect(Collectors.toList());
                    }
                    try {
                        drive.announceDrive(company, studentNames);
                    } catch (IllegalArgumentException e) {
                        LOG.warning("Announcement failed: " + e.getMessage());
                    }
                }
                case "4" -> {
                    LOG.info("Exiting Placement Drive System.");
                    running = false;
                    drive.shutdown(); // stop notification thread
                }
                default -> LOG.warning("Invalid option. Please enter 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }
}
