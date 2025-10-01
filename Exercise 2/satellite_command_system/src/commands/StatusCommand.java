package commands;

import satellite.Satellite;

public class StatusCommand implements Command {
    private final Satellite satellite;

    public StatusCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.printStatus();
    }
}
