package commands;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("""
        Available commands:
         rotate <North|South|East|West>
         activatePanels
         deactivatePanels
         collectData
         status
         reset

        Ensure all satellite commands are entered precisely, including case and spacing.
        """);
    }
}
