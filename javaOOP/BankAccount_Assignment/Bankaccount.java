class Bankaccount {
    // Member Variables
private double checking ;
private double savings ;
// Class Variables
private static int numberOfAccounts;
private static double totalAmountStored;

    // Constructor
public Bankaccount(double checking, double savings) {
        this.checking = checking;
        this.savings = savings;
        numberOfAccounts++;
        totalAmountStored += (checking + savings);
    }
public double getChecking() {
        return checking;
    }

    public double getSavings() {
        return savings;
    }

    
    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    // deposit
    public void deposit(double amount, boolean isChecking) {
        if (isChecking) {
            checking += amount;
        } else {
            savings += amount;
        }
        totalAmountStored += amount;
    }
    // withdraw
    public void withdraw(double amount, boolean isChecking) {
        if (isChecking) {
            if (checking >= amount) {
                checking -= amount;
                totalAmountStored -= amount;
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else {
            if (savings >= amount) {
                savings -= amount;
                totalAmountStored -= amount;
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        }
    }
    public static double getTotalAmountStored() {
        return totalAmountStored;
    }
    public double getAllAmount() {
        return savings + checking;
    }
}
