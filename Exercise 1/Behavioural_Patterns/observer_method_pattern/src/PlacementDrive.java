package src;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PlacementDrive {
    private static final Logger LOG = Logger.getLogger(PlacementDrive.class.getName());
    private static final Object CONSOLE_LOCK = new Object(); // shared lock for logging

    private final List<Observer> students = new ArrayList<>();

    public void register(Observer student) {
        Objects.requireNonNull(student, "Student cannot be null");

        for (Observer s : students) {
            if (s.getName().equalsIgnoreCase(student.getName())) {
                throw new IllegalArgumentException("Student with name '" + student.getName() + "' already registered.");
            }
        }

        students.add(student);
        synchronized (CONSOLE_LOCK) {
            LOG.info("Student registered successfully: " + student.getName());
        }
    }

    public boolean unregister(String studentName) {
        if (studentName == null || studentName.isBlank()) return false;
        boolean removed = students.removeIf(s -> s.getName().equalsIgnoreCase(studentName.trim()));
        synchronized (CONSOLE_LOCK) {
            if (removed) LOG.info("Student unregistered: " + studentName);
            else LOG.warning("No student found with name: " + studentName);
        }
        return removed;
    }

    public void announceDrive(String companyName, List<String> studentNames) {
        if (companyName == null || companyName.isBlank()) {
            throw new IllegalArgumentException("Company name cannot be null or blank");
        }

        String company = companyName.trim();

        if (students.isEmpty()) {
            synchronized (CONSOLE_LOCK) {
                LOG.warning("No students registered to notify for company: " + company);
            }
            return;
        }

        synchronized (CONSOLE_LOCK) {
            LOG.info("[Processing Announcement] New company visit: " + company);
        }

        List<Observer> toNotify = students;
        if (studentNames != null && !studentNames.isEmpty()) {
            toNotify = students.stream()
                .filter(s -> studentNames.stream().anyMatch(name -> name.equalsIgnoreCase(s.getName())))
                .collect(Collectors.toList());
        }

        for (Observer student : toNotify) {
            try {
                student.update(company); // synchronized in Student
            } catch (Exception e) {
                synchronized (CONSOLE_LOCK) {
                    LOG.severe("Failed to notify " + student.getName() + ": " + e.getMessage());
                }
            }
        }
    }

    public void shutdown() {
        // No shutdown needed since no threads
    }
}
