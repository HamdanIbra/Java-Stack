import java.util.ArrayList;
public class CoffeeKiosk{
    ArrayList<Item> menu ;
    ArrayList<Order> orders;
    private int itemsCount = 0;
    public CoffeeKiosk(){
        ArrayList<Item> newitems = ;
        this.menu =new ArrayList<Item>();
        this.orders =new ArrayList<Order>();
    }

    public void addMenuItem(String name,double price){
        Item item1 = new Item(name,price,this.itemsCount);
        this.itemsCount++;
        this.menu.add(item1);
    }

    public void displayMenu(){
        for (Item item : this.menu){
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() {
    
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Your code:
        Order order1=new Order(name);
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        this.displayMenu();
        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            order1.addItem(this.menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        
        this.orders.add(order1);

        order1.display();
        // After you have collected their order, print the order details 
        // as the example below. You may use the order's display method.

}

}