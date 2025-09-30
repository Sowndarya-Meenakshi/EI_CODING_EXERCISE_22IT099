import src.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Classroom classroom = new Classroom();
        Invoker invoker = new Invoker();

        List<String> students = new ArrayList<>();

        try {
            // Get multiple student names
            while (true) {
                System.out.print("Enter student name (or type 'done' to finish): ");
                String studentName = scanner.nextLine().trim();
                if (studentName.equalsIgnoreCase("done")) break;
                if (!studentName.isEmpty()) {
                    students.add(studentName);
                } else {
                    System.out.println("Student name cannot be empty.");
                }
            }

            if (students.isEmpty()) {
                logger.severe("No students provided. Exiting.");
                return;
            }

            boolean continueProgram = true;

            while (continueProgram) {
                System.out.print("Enter command (mute/unmute/exit): ");
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.isEmpty()) {
                    System.out.println("Command cannot be empty.");
                    continue;
                }

                switch (input) {
                    case "mute":
                    case "unmute":
                        // Ask which student
                        System.out.println("Students: " + students);
                        System.out.print("Enter student name to " + input + " (or 'all'): ");
                        String target = scanner.nextLine().trim();

                        if (target.equalsIgnoreCase("all")) {
                            for (String student : students) {
                                MuteCommand command = new MuteCommand(classroom, student);
                                invoker.setCommand(command);
                                if (input.equals("mute")) {
                                    invoker.executeCommand();
                                } else {
                                    invoker.undoCommand();
                                }
                            }
                        } else if (students.contains(target)) {
                            MuteCommand command = new MuteCommand(classroom, target);
                            invoker.setCommand(command);
                            if (input.equals("mute")) {
                                invoker.executeCommand();
                            } else {
                                invoker.undoCommand();
                            }
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case "exit":
                        logger.info("Exiting program...");
                        continueProgram = false;
                        break;

                    default:
                        System.out.println("Invalid command. Try again.");
                        logger.warning("Invalid command: " + input);
                        break;
                }
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error occurred: ", e);
        } finally {
            scanner.close();
            logger.info("Program terminated safely.");
        }
    }
}
