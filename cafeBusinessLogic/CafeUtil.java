import java.util.Arrays;
import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(int week) {
        int cupsNeeded = week * (week + 1)/2;
        return cupsNeeded;
    }

    public double getOrderTotal(double[] prices){
        double total = 0.0;
        // Arrays.toString(prices)
        for(int i = 0; i <prices.length; i++){
            total += prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0; i < menuItems.size() - 1; i++){
            System.out.println(i +" " +  menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        String userName = System.console().readLine();
        customers.add(userName);
        System.out.println("Hello, " + userName);
        System.out.println("There are " + customers.size() - 1 + " people in front of you");

    }
}