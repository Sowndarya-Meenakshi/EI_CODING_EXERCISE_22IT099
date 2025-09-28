package src;

import java.util.Map;

public class BasicReport implements Report {

    @Override
    public void generateReport(Student student) {
        Map<String, Integer> marks = student.getSubjectMarks();
        double average = marks.values().stream().mapToInt(Integer::intValue).average().orElse(0);

        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 75) grade = "B";
        else if (average >= 60) grade = "C";
        else grade = "D";

        System.out.println("\n===== Basic Report =====");
        System.out.println("Student: " + student.getName());
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("========================\n");
    }
}
