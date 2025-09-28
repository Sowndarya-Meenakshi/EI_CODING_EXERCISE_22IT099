package src;

import java.util.Map;

public class DetailedReport implements Report {

    @Override
    public void generateReport(Student student) {
        System.out.println("\n===== Detailed Report =====");
        System.out.println("Student: " + student.getName());

        // Print individual marks
        Map<String, Integer> marks = student.getSubjectMarks();
        if (marks.isEmpty()) {
            System.out.println("No marks available.");
        } else {
            for (Map.Entry<String, Integer> entry : marks.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        // Calculate and print average
        double average = student.getAverageMarks();
        System.out.printf("Average Marks: %.2f%n", average);

        // Print grade
        System.out.println("Grade: " + student.getGrade());

        // Print attendance
        System.out.printf("Attendance: %.2f%%%n", student.getAttendance());

        System.out.println("============================");
    }
}
