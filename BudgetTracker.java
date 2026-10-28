import java.util.ArrayList;

public class BudgetTracker {
  private double monthlyBudget;
  private ArrayList<Expense> expenses;
  
  public BudgetTracker(double monthlyBudget) {
    this.monthlyBudget = monthlyBudget;
    expenses = new ArrayList<>();
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
}
