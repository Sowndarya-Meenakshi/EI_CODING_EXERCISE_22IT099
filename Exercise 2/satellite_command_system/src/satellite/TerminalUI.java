package satellite;

import java.io.File;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import commands.Command;
import commands.CommandFactory;

public class TerminalUI {
    private final Satellite satellite;
    private final CommandFactory factory;
    private static final Logger logger = Logger.getLogger(TerminalUI.class.getName());

    public TerminalUI() {
        this.satellite = new Satellite();
        this.factory = new CommandFactory(satellite);

        try {
            // Create logs folder if it doesn't exist
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdir();
            }

            // Set log file inside logs folder
            FileHandler fh = new FileHandler("logs/satellite_log.txt", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        } catch (Exception e) {
            System.out.println("⚠️ Logging setup failed: " + e.getMessage());
        }
    }

    public void start() {
        System.out.println("🛰️ Welcome to Satellite Command System!");
        System.out.println("Your satellite begins with the following attributes:");
        satellite.printStatus();
        System.out.println("Type 'help' (case insensitive) or 'exit' (case insensitive) to get help or exit.\n");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Satellite Command System. Goodbye!");
                break;
            }

            Command cmd = factory.getCommand(input);
            if (cmd != null) {
                logger.info("Executing command: " + input);
                cmd.execute();
            } else {
                System.out.println("❌ Invalid command! Type 'help' for available options.");
            }
        }
        sc.close();
    }
}
