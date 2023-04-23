import java.time.LocalDateTime;
import java.util.ArrayList;
public class CafeUtil {
    
    public int getStreakGoal() {
        int sum=0;
        for (int i = 1;i<11;i++) {
            sum +=i;

        }
        return sum;
    }
    
    public double getOrderTotal(double[] prices){
        double sum=0;
        for (double price : prices) {
            sum += price;
        }
        return sum;
    }

    
    public void displayMenu( ArrayList<String> menuItems ){
        int count=0;
        for (String item : menuItems) {
            System.out.println(count +" "+ item);
            count++;
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName);
        int numOfPeople = customers.size();
        System.out.println("There are " + numOfPeople+ " people in front of you");
        customers.add(userName);
        for (String customer : customers){
            System.out.println(customer);
        }


    }
}
