package commands;

import satellite.Satellite;

public class ActivatePanelsCommand implements Command {
    private final Satellite satellite;

    public ActivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.activatePanels();
    }
}
