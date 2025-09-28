# Campus Placements Management System - Observer Design Pattern

This Java project demonstrates the Observer Design Pattern in a campus placements context. Students register for placement notifications and get notified when companies announce drives.

**Code Structure:**

- **Main.java:** Main class that provides a console-based menu for managing the placement drive system, allowing users to register students, unregister them, announce new placement drives, and exit the system.
- **Observer.java:** Defines the Observer interface with methods for updating observers about placement announcements and retrieving their unique ID and name.
- **Student.java:** Represents a student in the placement system who implements the Observer interface to receive notifications about new placement opportunities from companies.
- **PlacementDrive.java:** Acts as the subject in the Observer pattern, managing the list of registered students and handling notifications for placement drive announcements.

**How to Run:**

Compile: **javac -d bin Main.java src/*.java**  
Run: **java -cp bin Main**  
Follow the console menu to register students, announce drives, and manage the system.
