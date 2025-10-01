package satellite;

public class Satellite {
    private String orientation;
    private boolean solarPanelsActive;
    private int dataCollected;

    // Default values
    private static final String DEFAULT_ORIENTATION = "North";
    private static final boolean DEFAULT_PANELS = false;
    private static final int DEFAULT_DATA = 0;

    public Satellite() {
        reset();
    }

    public void reset() {
        this.orientation = DEFAULT_ORIENTATION;
        this.solarPanelsActive = DEFAULT_PANELS;
        this.dataCollected = DEFAULT_DATA;
    }

    public void rotate(String direction) {
        this.orientation = direction;
        System.out.println("🛰️ Satellite rotated to " + direction + " " + getArrow(direction));
    }

    public void activatePanels() {
        solarPanelsActive = true;
        System.out.println("🔆 Solar panels activated");
    }

    public void deactivatePanels() {
        solarPanelsActive = false;
        System.out.println("🌑 Solar panels deactivated");
    }

    public void collectData() {
        if (solarPanelsActive) {
            dataCollected += 10;
            System.out.println("📡 Data collected! Total: " + dataCollected);
        } else {
            System.out.println("⚠️ Cannot collect data: Solar panels are inactive!");
        }
    }

    public void printStatus() {
        System.out.println("Orientation: " + orientation + " " + getArrow(orientation)
                + " | Solar Panels: " + (solarPanelsActive ? "Active" : "Inactive")
                + " | Data Collected: " + dataCollected);
    }

    private String getArrow(String direction) {
        return switch (direction.toLowerCase()) {
            case "north" -> "↑";
            case "south" -> "↓";
            case "east" -> "→";
            case "west" -> "←";
            default -> "";
        };
    }
}
