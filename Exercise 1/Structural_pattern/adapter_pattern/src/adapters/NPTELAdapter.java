package adapters;

import core.StudentProgress;

public class NPTELAdapter implements PlatformAdapter {
    @Override
    public void updateProgress(StudentProgress sp, int score) {
        sp.setNptelScore(score);
        if(score >= 90) sp.addBadge("NPTEL Achiever");
    }
}
