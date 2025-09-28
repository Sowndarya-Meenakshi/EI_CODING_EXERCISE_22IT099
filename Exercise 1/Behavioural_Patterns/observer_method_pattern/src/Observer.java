package src;

public interface Observer {
    void update(String companyName);
    String getId();   // Unique ID
    String getName();
}
