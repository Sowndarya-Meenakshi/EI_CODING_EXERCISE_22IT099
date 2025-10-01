package commands;

import satellite.Satellite;

public class ResetCommand implements Command {
    private final Satellite satellite;

    public ResetCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.reset();
        System.out.println("🔁 Satellite reset to initial state:");
        satellite.printStatus();
    }
}
