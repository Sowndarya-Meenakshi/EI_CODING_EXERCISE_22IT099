package src;

import java.util.UUID;
import java.util.logging.Logger;

public class Student implements Observer {
    private static final Logger LOG = Logger.getLogger(Student.class.getName());
    private static final Object CONSOLE_LOCK = new Object(); // shared lock

    private final String id;
    private final String name;

    public Student(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Student name cannot be null or blank");
        }
        this.name = name.trim();
        this.id = UUID.randomUUID().toString();  // Unique identifier
    }

    @Override
    public void update(String companyName) {
        synchronized (CONSOLE_LOCK) {
            LOG.info(name + " is notified: New placement drive by " + companyName + "!");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
}
