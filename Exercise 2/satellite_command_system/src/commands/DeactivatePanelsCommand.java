package commands;

import satellite.Satellite;

public class DeactivatePanelsCommand implements Command {
    private final Satellite satellite;

    public DeactivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.deactivatePanels();
    }
}
