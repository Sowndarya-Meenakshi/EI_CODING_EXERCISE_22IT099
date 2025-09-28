package adapters;

import core.StudentProgress;

public interface PlatformAdapter {
    void updateProgress(StudentProgress sp, int score);
}
