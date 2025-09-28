package core;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Dashboard {
    private final Map<String, StudentProgress> studentData;

    public Dashboard() {
        this.studentData = new ConcurrentHashMap<>();
    }

    public void updateProgress(StudentProgress progress) {
        if(progress == null || progress.getStudentId() == null) return;
        studentData.put(progress.getStudentId(), progress);
        System.out.println("[Dashboard] Updated: " + progress);
    }

    public void displayLeaderboard() {
        System.out.println("\n[Leaderboard]");
        studentData.values().stream()
                .sorted((a,b) -> Integer.compare(
                        b.getLeetCodeScore() + b.getSkillRackScore() + b.getNptelScore(),
                        a.getLeetCodeScore() + a.getSkillRackScore() + a.getNptelScore()))
                .forEach(System.out::println);
        System.out.println();
    }

    // <-- Add this
    public StudentProgress getStudent(String studentId) {
        return studentData.get(studentId);
    }
}
