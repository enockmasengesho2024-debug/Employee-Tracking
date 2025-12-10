import java.util.ArrayList;
import java.util.List;

public class StoryEngine {

    //  Salary & Miles Calculations 

    public static int calculateMiles(int miles) {
        if (miles >= 10 && miles <= 30) {
            miles += 3;
        } else if (miles >= 31 && miles <= 50) {
            miles += 5;
        } else {
            miles += 8;
        }
        return miles;
    }

    public static int computeSalary(int punchIn, int punchOut, int hourlyRate) {
        int totalSalary = 0;
        for (int i = punchIn; i < punchOut; i++) {
            totalSalary += hourlyRate;
        }
        return totalSalary;
    }

    public static double computeMileageReimbursement(int miles) {
        final double RATE = 0.15;  // $0.15 per mile
        return miles * RATE;
    }

    //   Output of the story adventure

    public static void introduction(Employee emp, String[] company) {
        System.out.println("\n Company Adventure Story ");
        System.out.println(emp.getFullName() + " has been a loyal member of our company.");
        System.out.println(emp.getPossAdj() + " role is in the " + company[0] + ", "
                + company[3] + ", " + company[5] + " department.");
        System.out.println(emp.getSubj() + " drives " + emp.getMiles()
                + " miles each day and earns $" + emp.getTotalSalary() + " per day.\n");
    }

  // inheritance/polymorphism core

    public static StoryNode[] buildStoryOptions() {
        
        StoryNode wellness = new WellnessEventNode(
                "Lead a company wellness event",
                null
        );

        StoryNode ideaMeeting = new IdeaMeetingNode(
                "Join a team meeting to share a new product idea",
                new StoryNode[] { wellness }
        );

        StoryNode fixIssue = new FixIssueNode(
                 "Fix a critical computer issue in the IT department",
                new StoryNode[] { ideaMeeting }
        );

        StoryNode trainEmployee = new TrainingNode(
                "Help train a new employee",
                new StoryNode[] { fixIssue }
        );

        StoryNode bigProject = new BigProjectNode(
                "Take on a big new project for the company",
                new StoryNode[] { trainEmployee }
        );

        // Polymorphic collection, all StoryNode
        return new StoryNode[] { bigProject, trainEmployee, fixIssue, ideaMeeting, wellness };
    }

    //   recursive, polymorphic experience 

    //  play the story path (void)
    public static void playStoryFrom(StoryNode node, Employee emp) {
        if (node == null) {
            return; // base case
        }

        // Polymorphic call – actual version depends on child type
        node.play(emp);

        for (StoryNode child : node.getNextNodes()) {
            playStoryFrom(child, emp); // recursive call
        }
    }

    //  Scalar result (int)
    public static int countChapters(StoryNode node) {
        if (node == null) {
            return 0; // base case
        }

        int total = 1; // count this node
        for (StoryNode child : node.getNextNodes()) {
            total += countChapters(child); // recursive call
        }
        return total;
    }
 
    public static List<String> collectChapterTitles(StoryNode node) {
        List<String> titles = new ArrayList<>();
        collectChapterTitlesHelper(node, titles);
        return titles;
    }

    private static void collectChapterTitlesHelper(StoryNode node, List<String> titles) {
        if (node == null) {
            return; // base case
        }

        titles.add(node.getTitle());

        for (StoryNode child : node.getNextNodes()) {
            collectChapterTitlesHelper(child, titles); // recursive call
        }
    }

    // Updated resolveChoice: uses polymorphism and recursion
    public static void resolveChoice(int choice, StoryNode[] options, Employee emp) {
        if (choice < 1 || choice > options.length) {
            System.out.println("\nYou decide to take it easy today. Everyone needs a rest sometimes!");
            return;
        }

        StoryNode selected = options[choice - 1];

        System.out.println();
        System.out.println("You chose: " + selected.getTitle());
        System.out.println();

        //  Recursive polymorphic story
        playStoryFrom(selected, emp);

        //  Recursive scalar
        int chapters = countChapters(selected);
        System.out.println("\nThis path contained " + chapters + " chapter(s).");

        //  Recursive structure
        List<String> titles = collectChapterTitles(selected);
        System.out.println("Chapters visited: " + titles);
    }

    //  Overloaded summaries 

    public static void summary(Employee emp) {
        System.out.println("\nAt the end of the day, " + emp.getFullName() + " reflects on the achievements.");
        System.out.println("Working with " + emp.getNumEmployees() + " employees, all of " + emp.getObj()
                + " make the company strong.");
        System.out.println("It is " + emp.getChoice() + " that teamwork and passion lead to success!");
        System.out.println("Our headquarters at " + emp.getAddress()
                + " continues to grow — thanks to people like you.");
        System.out.println("\nCongratulations, " + emp.getFullName() + "! You have completed your company adventure.");
    }

    public static void summary(String fName) {
        System.out.println("\n" + fName + " smiles, ready for another day at the company tomorrow.");
    }

    //  New Chapter: Bonus Evaluation  

    public static void bonusChapter(Employee emp) {
        System.out.println("\n New Chapter: Bonus Evaluation");
        System.out.println("After the successful day, " + emp.getFullName() +
                " receives an invitation to a company review meeting.");

        System.out.println("Your manager is impressed by your hard work and daily miles!");
        System.out.println("Now, you have a chance to earn an end-of-week performance bonus.");

        if (emp.getMiles() > 40 && emp.getTotalSalary() > 150) {
            System.out.println("\nCongratulations! You earned a giftcard of $50 performance bonus!");
        } else if (emp.getMiles() >= 25) {
            System.out.println("\nNice effort! You earned a giftcard of $25 performance bonus!");
        } else {
            System.out.println("\nKeep going! No bonus this time, but your dedication is noted.");
        }

        System.out.println("\nThe review concludes with a team members celebration and pizza party!");
    }
}
