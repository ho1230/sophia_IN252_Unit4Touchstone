import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Start the budget tracker program
    Scanner input = new Scanner(System.in);
    System.out.println("***** BUDGET TRACKER *****");
    double budget = readPositiveAmount (input,
                                        "Enter your monthly budget: $");
    BudgetTracker tracker = new BudgetTracker(budget);
    boolean running = true;
    while (running){
      showMenu();
      System.out.print("Choose an option:");
      try {
        int choice = Integer.parseInt(choiceText);
        running = handleChoice(choice, input, tracker);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Enter a number.");
      }
      input.close();
    }
  }

  public static void showMenu() {
    // Display menu options
    System.out.println("\n***** MAIN MENU *****");
    System.out.println("1. Add Expense");
    System.out.println("2. View All Expenses");
    System.out.println("3. View Budget Summary");
    System.out.println("4. Exit");
  }
  
  public static void addExpense(
      Scanner scanner,
      BudgetTracker tracker) {
    // Get expense information from user
    System.out.println("\n***** ADD EXPENSE *****");
    System.out.print("Enter expense name: ");
    String name = input.nextLine();
    System.out.print("Enter category: ");
    String category = input.nextLine();
    double amount = readPositiveAmount(input,
            "Enter amount: $");
    Expense expense = new Expense(name, category, amount);
    tracker.addExpense(expense);
    System.out.println("Expense added!");
  }

  public static double readPositiveAmount(Scanner input,
                                          String message) {
    // Read and validate a positive money amount
    while (true) {
      System.out.print(message);
      String text = input.nextLine();
      try {
        double amount = Double.parseDouble(text);
        if (Double.isFinite(amount) && amount > 0) {
          return amount;
        }
        System.out.println("Please enter an amount greater than zero.");
      } catch (NumberFormatException e) {
        System.out.println("Invalid amount. Please enter a number.");
      }
    }
  }
  
  public static boolean handleChoice(
    int choice,
    Scanner scanner,
    BudgetTracker tracker) {
    // Perform selected action
    // Return false when user wants to exit
    switch (choice) {
      case 1:
        // Add a new expense
        addExpense(input, tracker);
        break;
      case 2:
        // Display recorded expenses
        tracker.displayExpenses();
        break;
      case 3:
        // Display the budget summary
        tracker.displaySummary();
        break;
      case 4:
        // Exit
        System.out.println("Thank you for using Smart Budget Tracker!");
        return false;
      default:
        // Handle all others
        System.out.println("Invalid option. Please choose 1-4.");
    }
    return true;
  }
}
