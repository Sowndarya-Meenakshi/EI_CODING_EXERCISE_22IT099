package src;

import java.util.Objects;

public class MuteCommand implements Command {

    private final Classroom classroom;
    private final String studentName;

    public MuteCommand(Classroom classroom, String studentName) {
        this.classroom = Objects.requireNonNull(classroom, "Classroom cannot be null");
        this.studentName = Objects.requireNonNull(studentName, "Student name cannot be null");
    }

    @Override
    public void execute() {
        classroom.muteStudent(studentName);
    }

    @Override
    public void undo() {
        classroom.unmuteStudent(studentName);
    }
}
