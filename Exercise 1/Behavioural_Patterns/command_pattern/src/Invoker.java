package src;

import java.util.logging.Logger;
public class Invoker {

    private static final Logger logger = Logger.getLogger(Invoker.class.getName());
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        try {
            if (command != null) {
                command.execute();
            } else {
                logger.warning("No command set to execute.");
            }
        } catch (Exception e) {
            logger.severe("Execution failed: " + e.getMessage());
        }
    }

    public void undoCommand() {
        try {
            if (command != null) {
                command.undo();
            } else {
                logger.warning("No command set to undo.");
            }
        } catch (Exception e) {
            logger.severe("Undo failed: " + e.getMessage());
        }
    }
}
