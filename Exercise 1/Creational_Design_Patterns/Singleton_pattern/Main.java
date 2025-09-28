import src.ExamSession;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExamSession session = ExamSession.getInstance();

        boolean running = true;

        while (running) {
            System.out.println("\n===== Exam Menu =====");
            System.out.println("1. Start Exam");
            System.out.println("2. End Exam");
            System.out.println("3. Student Login");
            System.out.println("4. Show Logged-in Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> session.startExam();
                    case "2" -> session.endExam();
                    case "3" -> {
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine().trim();
                        session.studentLogin(name);
                    }
                    case "4" -> {
                        System.out.println("Logged-in Students: " + session.getLoggedInStudents());
                    }
                    case "5" -> {
                        LOG.info("Exiting Exam System...");
                        running = false;
                    }
                    default -> LOG.warning("Invalid option. Please select 1-5.");
                }
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Unexpected error occurred: ", e);
            }
        }

        scanner.close();
    }
}
