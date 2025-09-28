package adapters;

import core.StudentProgress;

public class SkillRackAdapter implements PlatformAdapter {
    @Override
    public void updateProgress(StudentProgress sp, int score) {
        sp.setSkillRackScore(score);
        if(score >= 90) sp.addBadge("SkillRack Expert");
    }
}
