package core;

import java.util.ArrayList;
import java.util.List;

public class StudentProgress {
    private String studentId;
    private int leetCodeScore;
    private int skillRackScore;
    private int nptelScore;
    private List<String> badges;

    public StudentProgress(String studentId) {
        this.studentId = studentId;
        this.badges = new ArrayList<>();
    }

    public String getStudentId() { return studentId; }

    public int getLeetCodeScore() { return leetCodeScore; }
    public void setLeetCodeScore(int leetCodeScore) { this.leetCodeScore = leetCodeScore; }

    public int getSkillRackScore() { return skillRackScore; }
    public void setSkillRackScore(int skillRackScore) { this.skillRackScore = skillRackScore; }

    public int getNptelScore() { return nptelScore; }
    public void setNptelScore(int nptelScore) { this.nptelScore = nptelScore; }

    public List<String> getBadges() { return badges; }
    public void addBadge(String badge) { 
        if(!badges.contains(badge)) badges.add(badge); 
    }

    @Override
    public String toString() {
        return String.format(
            "Student %s: LeetCode %d%%, SkillRack %d%%, NPTEL %d%%, Badges %s",
            studentId, leetCodeScore, skillRackScore, nptelScore, badges
        );
    }
}
