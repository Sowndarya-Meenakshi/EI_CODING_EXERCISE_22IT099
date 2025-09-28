package src;

import java.util.Collections;
import java.util.Map;

public class Student {
    private final String name;
    private final Map<String, Integer> subjectMarks;
    private final double attendance;

    public Student(String name, Map<String, Integer> subjectMarks, double attendance) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        if (subjectMarks == null) throw new IllegalArgumentException("Subject marks cannot be null");
        if (attendance < 0 || attendance > 100) throw new IllegalArgumentException("Attendance must be 0-100");

        this.name = name.trim();
        this.subjectMarks = subjectMarks;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getSubjectMarks() {
        return Collections.unmodifiableMap(subjectMarks);
    }

    public double getAttendance() {
        return attendance;
    }

    public double getAverageMarks() {
        if (subjectMarks.isEmpty()) return 0;
        return subjectMarks.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String getGrade() {
        double avg = getAverageMarks();
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        if (avg >= 50) return "D";
        return "F";
    }
}
