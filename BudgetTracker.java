import java.util.ArrayList;

public class BudgetTracker {
  private double monthlyBudget;
  private ArrayList<Expense> expenses;
  
  public BudgetTracker(double monthlyBudget) {
    this.monthlyBudget = monthlyBudget;
    this.expenses = new ArrayList<>();
  }
  
  public void addExpense(Expense expense) {
    expenses.add(expense);
  }
  
  public double calculateTotal() {
    double total = 0;
    for (Expense expense : expenses) {
      total += expense.getAmount();
    }
    return total;
  }
  
  public double getRemainingBudget() {
    return monthlyBudget - calculateTotal();
  }

  public boolean isOverBudget() {
    return calculateTotal() > monthlyBudget;
  }

  public void displayExpenses() {
    System.out.println("\n***** EXPENSE LIST *****\n");
    if (expenses.isEmpty()) {
        System.out.println("No recorded");
        return;
    }
    
    for (Expense expense : expenses) {
      System.out.println(
        expense.getName() + " | " +
        expense.getCategory() + " | $" +
        String.format("%.2f", expense.getAmount())
      );
    }
  }

  public void displaySummary() {
    System.out.println("\n***** BUDGET SUMMARY *****\n");
    System.out.printf("Monthly Budget: $%.2f%n", monthlyBudget);
    System.out.printf("Total Expenses: $%.2f%n", calculateTotal());
    System.out.printf("Remaining Budget: $%.2f%n", getRemainingBudget());
    
    if (isOverBudget()) {
      System.out.println("Warning: You exceeded your budget!");
    } else {
      System.out.println("You are within your budget!");
    }
  }
  
}
