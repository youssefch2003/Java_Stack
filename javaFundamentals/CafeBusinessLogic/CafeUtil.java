import java.util.ArrayList;
import java.text.DecimalFormat;
public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

        public double getOrderTotal(double[] prices) {
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }
        return total;

        
    }
    
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "!");

        int numPeople = customers.size();
        System.out.println("There are " + numPeople + " people in front of you");

        customers.add(userName);
        System.out.println(customers);
    }
     public void printPrice(String product, double price, int maxQuantity) {
        DecimalFormat decimalFormat = new DecimalFormat("$0.00");

        System.out.println(product);
        for (int quantity = 1; quantity <= maxQuantity; quantity++) {
            double totalPrice = price * quantity;
            System.out.println(quantity + " - " + decimalFormat.format(totalPrice));
        }
    }




  

}