# Exam Session Manager - Singleton Design Pattern

This Java project demonstrates the **Singleton Design Pattern** for managing a single exam session instance. It ensures only one ExamSession object exists, providing global access to control exam start/end, student logins, and logged-in student list via console menu.

**Features:**
- Start and end the exam session.
- Student login (only when exam is active).
- View list of logged-in students.
- Thread-safe implementation using double-checked locking.

**Code Structure:**
- **ExamSession.java**: Singleton class managing exam state, student logins, and synchronization for thread safety.
- **Main.java**: Console interface for user interaction, obtaining the singleton instance and performing operations.

**How to Run:**
1. Compile: `javac -d bin Main.java src/*.java`
2. Run: `java -cp bin Main`
3. Use menu options: 1 to start exam, 2 to end, 3 to login student, 4 to show students, 5 to exit.


