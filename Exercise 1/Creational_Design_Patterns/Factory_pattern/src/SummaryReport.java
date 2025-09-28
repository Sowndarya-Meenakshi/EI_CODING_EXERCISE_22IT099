package src;

import java.util.Map;

public class SummaryReport implements Report {

    @Override
    public void generateReport(Student student) {
        Map<String, Integer> marks = student.getSubjectMarks();
        double average = marks.values().stream().mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("\n===== Summary Report =====");
        System.out.println("Student: " + student.getName());
        marks.forEach((subject, score) -> System.out.println(subject + ": " + score));
        System.out.println("Average Marks: " + average);
        System.out.println("===========================\n");
    }
}
