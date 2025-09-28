import adapters.*;
import core.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        List<String> students = new ArrayList<>(Arrays.asList("S101","S102","S103"));

        Map<String, Map<String, PlatformAdapter>> adapterMap = new HashMap<>();
        for(String s : students) {
            Map<String, PlatformAdapter> platforms = new HashMap<>();
            platforms.put("LeetCode", new LeetCodeAdapter());
            platforms.put("SkillRack", new SkillRackAdapter());
            platforms.put("NPTEL", new NPTELAdapter());
            adapterMap.put(s, platforms);
            dashboard.updateProgress(new StudentProgress(s)); // initialize
        }

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("\n=== Student Progress Tracker ===");
            System.out.println("1. Update Student Progress");
            System.out.println("2. View Leaderboard");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch(choice) {
                case "1":
                    // Select student
                    System.out.println("Select Student:");
                    for(int i=0;i<students.size();i++)
                        System.out.printf("%d. %s\n", i+1, students.get(i));
                    System.out.print("> ");
                    int sIndex = Integer.parseInt(sc.nextLine()) - 1;
                    if(sIndex<0 || sIndex>=students.size()) { System.out.println("Invalid student."); break; }
                    String studentId = students.get(sIndex);
                    StudentProgress sp = dashboard.getStudent(studentId);

                    // Select platform
                    System.out.println("Select Platform:");
                    List<String> platforms = Arrays.asList("LeetCode","SkillRack","NPTEL","All");
                    for(int i=0;i<platforms.size();i++) System.out.printf("%d. %s\n",i+1,platforms.get(i));
                    System.out.print("> ");
                    int pIndex = Integer.parseInt(sc.nextLine()) - 1;
                    if(pIndex<0 || pIndex>platforms.size()-1) { System.out.println("Invalid platform."); break; }

                    List<String> selectedPlatforms = new ArrayList<>();
                    if(pIndex == 3) selectedPlatforms.addAll(Arrays.asList("LeetCode","SkillRack","NPTEL"));
                    else selectedPlatforms.add(platforms.get(pIndex));

                    // Enter scores
                    for(String plat : selectedPlatforms) {
                        System.out.printf("Enter score for %s (0-100) or 'r' for random: ", plat);
                        String input = sc.nextLine();
                        int score;
                        if(input.equalsIgnoreCase("r"))
                            score = new Random().nextInt(101);
                        else {
                            try { score = Integer.parseInt(input); }
                            catch(Exception e) { System.out.println("Invalid input. Skipping."); continue; }
                        }
                        adapterMap.get(studentId).get(plat).updateProgress(sp, score);
                    }

                    dashboard.updateProgress(sp);
                    break;

                case "2":
                    dashboard.displayLeaderboard();
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("=== Tracker terminated ===");
    }
}
