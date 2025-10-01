package commands;

import satellite.Satellite;

public class CollectDataCommand implements Command {
    private final Satellite satellite;

    public CollectDataCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.collectData();
    }
}
