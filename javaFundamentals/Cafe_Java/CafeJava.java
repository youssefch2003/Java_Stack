public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly, ";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        double Latte = 2.5;
        double Cappuccino = 6.5;
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
          System.out.println(pendingMessage + customer1);
    	// ** Your customer interaction print statements will go here ** //
        if(isReadyOrder4){
             System.out.println(customer4 + readyMessage + displayTotalMessage + Cappuccino );
        }else{
             System.out.println(pendingMessage + customer4);
        }
        // Sam ordered 2 latte
        System.out.println(customer2 + displayTotalMessage + Latte*2);
        if(isReadyOrder2){
            isReadyOrder2 = false;
        }else{
            isReadyOrder2 = true;
        }
        System.out.println(isReadyOrder2);
        double  owes = Latte - dripCoffee ;
        System.out.println(customer3 + "u owes"+ owes );
        // Try changing the price values for each drink and isReady
        //  flags (booleans), to test if all of your logic works, 
        // even when prices and statuses are changed.*
        Latte = 4.0;
        Cappuccino = 6.0;
        isReadyOrder2 = false;
        isReadyOrder4 = false;
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage + displayTotalMessage + Cappuccino);
        } else {
            System.out.println(pendingMessage + customer4);
        }

        System.out.println(customer2 + displayTotalMessage + Latte * 2);
        if (isReadyOrder2) {
            isReadyOrder2 = false;
        } else {
            isReadyOrder2 = true;
        }
        System.out.println(customer2 + " order status: " + (isReadyOrder2 ? "ready" : "pending"));

    }
}
// OUTPUT
// $ java CafeJava
// Welcome to Cafe Java, Cindhuri
// , your order will be ready shortly, Cindhuri
// Noah, your order is readyYour total is $6.5
// SamYour total is $5.0
// false
// Jimmyu owes0.0
// , your order will be ready shortly, Noah
// SamYour total is $8.0
// Sam order status: ready