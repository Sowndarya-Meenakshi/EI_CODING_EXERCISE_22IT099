package commands;

import satellite.Satellite;

public class RotateCommand implements Command {
    private final Satellite satellite;
    private final String direction;

    public RotateCommand(Satellite satellite, String direction) {
        this.satellite = satellite;
        this.direction = direction;
    }

    @Override
    public void execute() {
        satellite.rotate(direction);
    }
}
