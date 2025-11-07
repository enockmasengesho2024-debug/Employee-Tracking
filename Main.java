public class Main {
    public static void main(String[] args) {
        InputHelper helper = new InputHelper();
       //addd
        // Collect user input
        String fName = helper.getString("Enter your first name: ");
        String lName = helper.getString("Enter your last name: ");
        String proPossAdj = helper.getString("Choose a possessive adjective (his/her/their): ");
        int age = helper.getValidatedInt("Enter your age (must be above 18): ", 19, 120);
        String proSubj = helper.getString("Choose a pronoun subject (he/she/they): ");
        int miles = StoryEngine.calculateMiles(helper.getValidatedInt("Enter the miles you drive daily: ", 1, 500));
        int punchIn = helper.getValidatedInt("Punch in time (24-hour clock): ", 0, 23);
        int punchOut = helper.getValidatedInt("Punch out time (24-hour clock): ", punchIn + 1, 23);
        int hourlyRate = helper.getValidatedInt("Enter hourly rate: ", 1, 200);
        int totalSalary = StoryEngine.computeSalary(punchIn, punchOut, hourlyRate);
        int numEmployees = helper.getValidatedInt("Number of employees: ", 1, 10000);
        String proObj = helper.getString("Choose a pronoun object (him/her/them): ");
        boolean choose = helper.getBoolean("Choose true or false: ");
        String address = helper.getString("Enter your address: ");

        // Arrays
        String[] company = {"Marketing", "Finance", "Human Resources", "Customer Service", "Training", "Recruiting"};
        String[] storyPaths = {
            "Take on a big new project for the company.",
            "Help train a new employee.",
            "Fix a critical computer issue in the IT department.",
            "Join a team meeting to share a new product idea."
        };

        // Create Employee object
        Employee emp = new Employee(fName, lName, proPossAdj, proSubj, proObj, address, choose, age, miles, punchIn, punchOut, hourlyRate, totalSalary, numEmployees);

        // Display story
        StoryEngine.introduction(emp, company);

        // Story choice
        int choice = helper.getValidatedInt("What will you do today? (Enter 1-" + storyPaths.length + "): ", 1, storyPaths.length);
        StoryEngine.resolveChoice(choice, storyPaths);

        // Salary Report
        double mileageReimbursement = StoryEngine.computeMileageReimbursement(miles);
        double totalPay = totalSalary + mileageReimbursement;
        System.out.println("\nTotal Salary: $" + totalSalary);
        System.out.println("Mileage Reimbursement: $" + mileageReimbursement);
        System.out.println("Total Pay (Salary + Mileage): $" + totalPay);

        // Summaries
        StoryEngine.summary(emp);
        StoryEngine.summary(fName);

        helper.close();
    }
}
