import java.util.ArrayList;

public class TestOrder {
    public static void main(String[] args) {

        // Menu items
        Item item1 = new Item("exp", 4.5);
        Item item2 = new Item("latte", 3.5);
        Item item3 = new Item("coffee", 2.0);
        Item item4 = new Item("cappuccino", 5.0);

     
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");
    // the total will be 0.0
        System.out.println(order1);

    

      
        order2.getItems().add(item1);
        order2.setTotal(order2.getTotal() + item1.getPrice());
      
          order3.getItems().add(item4);
        order3.setTotal(order3.getTotal() + item4.getPrice());


      
        order4.getItems().add(item2);
        order4.setTotal(order4.getTotal() + item2.getPrice());

    
        order1.setReady(true);

      
        order4.getItems().add(item2);
        order4.setTotal(order4.getTotal() + (item2.getPrice() * 2));

       
        order2.setReady(true);

      
        System.out.printf("Name: %s\n", order1.getName());
        System.out.printf("Total: %.2f\n", order4.getTotal());
        System.out.printf("Ready: %s\n", order1.isReady());
        order2.setReady(true);
    }
}
