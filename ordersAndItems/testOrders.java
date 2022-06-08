import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
        
        // Menu items

        Item item1 = new Item("Drip", 5.99);
        Item item2 = new Item("Mocha", 8.99);
        Item item3 = new Item("latte", 2.99);
        Item item4 = new Item("Capuccino", 3.99);


        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Chinduri", 5.99,true, item1);
        Order order2 = new Order("Jimmy", 8.99, true, item2);
        Order order3 = new Order("Noah", 2.99, true, item3);
        Order order4 = new Order("Sam", 3.99, true, item4);
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
