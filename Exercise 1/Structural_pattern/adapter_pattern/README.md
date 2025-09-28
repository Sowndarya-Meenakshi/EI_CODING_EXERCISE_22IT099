# Student Progress Tracker - Adapter Design Pattern

This Java project demonstrates the **Adapter Design Pattern** for integrating multiple online learning platforms (LeetCode, SkillRack, NPTEL) into a unified student progress dashboard. Adapters convert platform-specific score updates to a common interface, allowing seamless aggregation of progress, badges, and leaderboard ranking.

**Features:**
- Update student scores from different platforms via adapters.
- Award badges for high scores (e.g., >=90%).
- Display leaderboard sorted by total scores.
- Console-based menu for interactive progress management.

**Code Structure:**
- **PlatformAdapter.java**: Target interface defining the common updateProgress method for all platforms.
- **LeetCodeAdapter.java**: Adapter for LeetCode, updates LeetCode score and awards "LeetCode Topper" badge.
- **NPTELAdapter.java**: Adapter for NPTEL, updates NPTEL score and awards "NPTEL Achiever" badge.
- **SkillRackAdapter.java**: Adapter for SkillRack, updates SkillRack score and awards "SkillRack Expert" badge.
- **StudentProgress.java**: Core class holding student data (ID, scores per platform, badges).
- **Dashboard.java**: Manages student progress storage, updates, and leaderboard display using ConcurrentHashMap for thread safety.
- **Main.java**: Entry point with console menu to select students/platforms, input scores (manual or random), and view results.

**How to Run:**
1. Compile: `javac -d bin Main.java src/**/*.java`
2. Run: `java -cp bin Main`
3. Use menu: 1 to update progress (select student/platform/score), 2 for leaderboard, 3 to exit.

