public class TestBankAccount {
    public static void main(String[] args) {
        // Creating a new BankAccount object
        Bankaccount account1 = new Bankaccount(1000, 2000);

        // Checking initial balances
        System.out.println(account1.getChecking());
        System.out.println(account1.getSavings());
        System.out.println(account1.getAllAmount());

        // Making a deposit
        account1.deposit(500, true);
        account1.deposit(1000, false);

        System.out.println( account1.getChecking());
        System.out.println(  account1.getSavings());
        System.out.println(account1.getAllAmount());

        // Making a withdrawal
        account1.withdraw(800, true); 
        account1.withdraw(2500, false);

        
        System.out.println( account1.getChecking());
        System.out.println(account1.getSavings());
        System.out.println( account1.getAllAmount());


        System.out.println( Bankaccount.getNumberOfAccounts());
        System.out.println( Bankaccount.getTotalAmountStored());
    }
}
