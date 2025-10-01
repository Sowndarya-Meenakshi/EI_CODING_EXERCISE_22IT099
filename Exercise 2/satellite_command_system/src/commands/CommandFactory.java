package commands;

import satellite.Satellite;

public class CommandFactory {

    private final Satellite satellite;

    public CommandFactory(Satellite satellite) {
        this.satellite = satellite;
    }

    public Command getCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        String[] parts = input.trim().split("\\s+");
        String cmd = parts[0];

        // Handle case insensitive commands
        if (cmd.equalsIgnoreCase("help")) {
            return new HelpCommand();
        }
        if (cmd.equalsIgnoreCase("exit")) {
            return new ExitCommand();
        }

        switch (cmd) {
            case "rotate" -> {
                if (parts.length < 2) return null;
                String direction = parts[1];
                if (!direction.equals("North") && !direction.equals("South") && !direction.equals("East") && !direction.equals("West")) {
                    return null;
                }
                return new RotateCommand(satellite, direction);
            }
            case "activatePanels" -> {
                return new ActivatePanelsCommand(satellite);
            }
            case "deactivatePanels" -> {
                return new DeactivatePanelsCommand(satellite);
            }
            case "collectData" -> {
                return new CollectDataCommand(satellite);
            }
            case "status" -> {
                return new StatusCommand(satellite);
            }
            case "reset" -> {
                return new ResetCommand(satellite);
            }
            default -> {
                return null;
            }
        }
    }
}
