package src;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ExamSession {

    private static final Logger LOG = Logger.getLogger(ExamSession.class.getName());

    private static volatile ExamSession instance;

    private String examName;
    private boolean isActive;
    private final List<String> loggedInStudents;

    // Private constructor
    private ExamSession(String examName) {
        this.examName = (examName == null || examName.isBlank()) ? "Default Exam" : examName;  //Default name is set to exam session if no name is given
        this.isActive = false;
        this.loggedInStudents = Collections.synchronizedList(new ArrayList<>());
    }

    // Double-checked locking singleton
    public static ExamSession getInstance() {
        if (instance == null) {
            synchronized (ExamSession.class) {
                if (instance == null) {
                    instance = new ExamSession("Maths Exam");
                    LOG.info("ExamSession instance created for " + instance.examName);
                }
            }
        }
        return instance;
    }

    public synchronized void startExam() {
        if (isActive) {
            LOG.warning("Exam " + examName + " is already active!");
            return;
        }
        isActive = true;
        LOG.info("Exam " + examName + " started!");
    }

    public synchronized void endExam() {
        if (!isActive) {
            LOG.warning("Exam " + examName + " is not active!");
            return;
        }
        isActive = false;
        LOG.info("Exam " + examName + " ended!");
    }

    public void studentLogin(String studentName) {
        if (studentName == null || studentName.isBlank()) {
            LOG.warning("Cannot login: student name is invalid.");
            return;
        }

        if (!isActive) {
            LOG.warning("Cannot login, exam not active.");
            return;
        }

        synchronized (loggedInStudents) {
            if (loggedInStudents.contains(studentName)) {
                LOG.warning(studentName + " already logged in.");
                return;
            }
            loggedInStudents.add(studentName);
        }
        LOG.info(studentName + " logged in successfully.");
    }

    public List<String> getLoggedInStudents() {
        synchronized (loggedInStudents) {
            return new ArrayList<>(loggedInStudents);
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public String getExamName() {
        return examName;
    }
}
