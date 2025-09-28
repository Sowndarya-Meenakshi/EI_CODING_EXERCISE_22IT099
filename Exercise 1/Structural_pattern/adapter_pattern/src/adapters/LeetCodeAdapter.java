package adapters;

import core.StudentProgress;

public class LeetCodeAdapter implements PlatformAdapter {
    @Override
    public void updateProgress(StudentProgress sp, int score) {
        sp.setLeetCodeScore(score);
        if(score >= 90) sp.addBadge("LeetCode Topper");
    }
}
