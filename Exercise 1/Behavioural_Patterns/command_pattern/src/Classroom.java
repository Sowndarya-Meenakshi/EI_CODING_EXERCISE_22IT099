package src;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Receiver class that performs actions in the Virtual Classroom.
 */
public class Classroom {

    private static final Logger logger = Logger.getLogger(Classroom.class.getName());

    // Track state of each student
    private final Map<String, Boolean> studentMuteState = new HashMap<>();
    // true = muted, false = unmuted

    /**
     * Adds a student with default state unmuted.
     */
    public void addStudent(String studentName) {
        if (studentName == null || studentName.isBlank()) return;
        studentMuteState.putIfAbsent(studentName, false); // default = unmuted
    }

    public void muteStudent(String studentName) {
        if (studentName == null || studentName.isBlank()) {
            logger.warning("Attempted to mute a student with empty name.");
            System.out.println("Student name cannot be empty.");
            return;
        }

        addStudent(studentName); // ensure student exists

        if (studentMuteState.get(studentName)) {
            System.out.println(studentName + " is already muted.");
            logger.info(studentName + " was already muted.");
        } else {
            studentMuteState.put(studentName, true);
            System.out.println(studentName + " is muted.");
            logger.info(studentName + " is now muted.");
        }
    }

    public void unmuteStudent(String studentName) {
        if (studentName == null || studentName.isBlank()) {
            logger.warning("Attempted to unmute a student with empty name.");
            System.out.println("Student name cannot be empty.");
            return;
        }

        addStudent(studentName); // ensure student exists

        if (!studentMuteState.get(studentName)) {
            System.out.println(studentName + " is already unmuted.");
            logger.info(studentName + " was already unmuted.");
        } else {
            studentMuteState.put(studentName, false);
            System.out.println(studentName + " is unmuted.");
            logger.info(studentName + " is now unmuted.");
        }
    }
}
