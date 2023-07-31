import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {

        // first
        CafeUtil cafeUtil = new CafeUtil();
        int numWeeks = 10;
        int streakGoal = cafeUtil.getStreakGoal(numWeeks);
        // System.out.println("Streak goal for " + numWeeks + " weeks: " + streakGoal);
        // second
        double[] prices = {2.5, 3.0, 4.45, 3.05};
        double total = cafeUtil.getOrderTotal(prices);
        System.out.println("Total Order Amount: $" + total);
        // Test displayMenu method
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");

        // cafeUtil.displayMenu(menuItems);
          ArrayList<String> customers = new ArrayList<>();
        customers.add("ahmed");
        customers.add("amine");
        cafeUtil.addCustomer(customers);

        cafeUtil.printPrice("Coffee",15.0,3);
    }
}
