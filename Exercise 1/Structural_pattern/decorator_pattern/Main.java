import decorators.*;

import java.util.Scanner;
import java.util.logging.*;
import base.*;
import decorators.*;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        configureLogger();
        logger.info("Student Fee Calculation System Started");

        boolean continueProgram = true;
        while (continueProgram) {
            try {
                double tuition = getPositiveDouble("Enter base tuition fee: $");
                FeeComponent fee = new TuitionFee(tuition);
                logger.info("Base tuition fee set: $" + tuition);

                if (getYesNo("Add Hostel Fee?").equals("y")) {
                    double hostel = getPositiveDouble("Enter hostel fee: $");
                    fee = new HostelFeeDecorator(fee, hostel);
                    logger.info("Hostel fee added: $" + hostel);
                }

                if (getYesNo("Add Sports Fee?").equals("y")) {
                    double sports = getPositiveDouble("Enter sports fee: $");
                    fee = new SportsFeeDecorator(fee, sports);
                    logger.info("Sports fee added: $" + sports);
                }

                if (getYesNo("Apply Scholarship Discount?").equals("y")) {
                    double discount = getPositiveDouble("Enter scholarship amount: $");
                    fee = new ScholarshipDiscountDecorator(fee, discount);
                    logger.info("Scholarship discount applied: $" + discount);
                }

                System.out.println("\n--- Final Fee Breakdown ---");
                System.out.println(fee.getDescription());
                System.out.println("Total Payable: $" + fee.getFee());
                System.out.println("---------------------------\n");

                continueProgram = getYesNo("Do you want to calculate fees for another student?").equals("y");

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error processing fee calculation", e);
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }

        logger.info("Student Fee Calculation System Ended");
        System.out.println("Thank you for using Student Fee Calculation System!");
    }

    // ---------------------- Input Validation ----------------------
    private static double getPositiveDouble(String prompt) {
        double value = -1;
        while (value < 0) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value < 0) {
                    System.out.println("Value cannot be negative. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a numeric value.");
            }
        }
        return value;
    }

    private static String getYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("n")) return input;
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }

    // ---------------------- Logger Configuration ----------------------
    private static void configureLogger() {
        Logger rootLogger = Logger.getLogger("");
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        rootLogger.addHandler(consoleHandler);
        rootLogger.setLevel(Level.INFO);
        rootLogger.setUseParentHandlers(false);
    }
}
