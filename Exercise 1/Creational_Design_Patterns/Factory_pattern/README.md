# Student Report Generation - Factory Design Pattern

This Java project demonstrates the **Factory Design Pattern** (Simple Factory variant) for generating student reports. Users input student data (name, subject marks, attendance) and select report types ("basic", "summary", "detailed") via console. The factory encapsulates creation logic, avoiding direct instantiation and promoting extensibility.

**Report Types:**
- **Basic**: Average marks and grade.
- **Summary**: Subject marks and average.
- **Detailed**: Subject marks, average, grade, and attendance.

**Code Structure:**
- **Report.java**: Defines the interface for all report types, specifying the method to generate reports for a student.
- **BasicReport.java**: Implements basic report generation, calculating and displaying average marks and grade.
- **SummaryReport.java**: Implements summary report generation, listing subject marks and average.
- **DetailedReport.java**: Implements detailed report generation, including subject marks, average, grade, and attendance.
- **ReportFactory.java**: Provides a static method to create report instances based on the specified type string.
- **Student.java**: Represents a student with name, subject marks, attendance, and methods to compute average and grade.

**How to Run:**
1. Compile: `javac -d bin Main.java src/*.java`
2. Run: `java -cp bin Main`
3. Enter student details and select report types ("basic"/"summary"/"detailed", "next" for new student, "exit" to quit).


