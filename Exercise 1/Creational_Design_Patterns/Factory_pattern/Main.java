import src.*;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Student Progress Tracker ===");

        boolean running = true;
        while (running) {

            try {
                // Step 1: Input student data
                System.out.print("\nEnter student name (or 'exit' to quit): ");
                String name = scanner.nextLine().trim();
                if (name.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting application...");
                    break;
                }
                if (name.isBlank()) {
                    System.out.println("Student name cannot be empty. Try again.");
                    continue;
                }

                Map<String, Integer> subjectMarks = new LinkedHashMap<>();
                while (true) {
                    System.out.print("Enter subject name (or leave blank to finish): ");
                    String subject = scanner.nextLine().trim();
                    if (subject.isBlank()) break;

                    System.out.print("Enter marks for " + subject + ": ");
                    String marksInput = scanner.nextLine().trim();
                    try {
                        int marks = Integer.parseInt(marksInput);
                        if (marks < 0 || marks > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            continue;
                        }
                        subjectMarks.put(subject, marks);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks. Enter an integer value.");
                    }
                }

                System.out.print("Enter attendance percentage: ");
                double attendance;
                try {
                    attendance = Double.parseDouble(scanner.nextLine().trim());
                    if (attendance < 0 || attendance > 100) {
                        System.out.println("Attendance must be between 0 and 100.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid attendance. Enter a number.");
                    continue;
                }

                Student student = new Student(name, subjectMarks, attendance);

                // Step 2: Generate multiple reports for the same student
                boolean reportLoop = true;
                while (reportLoop) {
                    System.out.println("\nSelect Report Type (basic/summary/detailed) or 'next' for next student or 'exit' to quit:");
                    String reportType = scanner.nextLine().trim().toLowerCase();

                    switch (reportType) {
                        case "basic", "summary", "detailed" -> {
                            try {
                                Report report = ReportFactory.createReport(reportType);
                                report.generateReport(student);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        case "next" -> reportLoop = false; // move to next student
                        case "exit" -> {
                            reportLoop = false;
                            running = false; // exit entire program
                        }
                        default -> System.out.println("Invalid input. Try 'basic', 'summary', 'detailed', 'next', or 'exit'.");
                    }
                }

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Application terminated.");
    }
}
