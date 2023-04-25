import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("mocha",10);
        Item item2 = new Item("latte",8);
        Item item3 = new Item("drip coffee",12);
        Item item4 = new Item("capuccino",15);

        Order order1=new Order();
        Order order2=new Order();
        Order order3=new Order("Cindhuri");
        Order order4=new Order("Jimmy");
        Order order5=new Order("Noah");

        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item2);
        order2.addItem(item3);

        order3.addItem(item4);
        order3.addItem(item3);

        order4.addItem(item1);
        order4.addItem(item4);

        order2.setReadyStatus(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order1.getOrderTotal());
        
        order1.display();
        order2.display();
        order3.display();
        order4.display();

        
        // // order4.name="Sam";

        // System.out.println(order1);
        // System.out.println(order1.total);

        // ArrayList<Item> order2ItemsArray = new ArrayList<Item>();
        // order2.items=order2ItemsArray;
        // order2.items.add(item1);
        // order2.total+=item1.price;
        // System.out.println(order2.total);
        // // Order variables -- order1, order2 etc.
        // ArrayList<Item> order3ItemsArray = new ArrayList<Item>();
        // order3.items=order3ItemsArray;
        // order3.items.add(item4);
        // order3.total+=item4.price;


        // ArrayList<Item> order4ItemsArray = new ArrayList<Item>();
        // order4.items=order4ItemsArray;
        // order4.items.add(item2);
        // order4.total+=item2.price;

        // order1.ready=true;

        // order4.items.add(item2);
        // order4.total+=item2.price;
        // order4.items.add(item2);
        // order4.total+=item2.price;

        // order2.ready=true;

        // // Application Simulations
        // // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);


        // System.out.printf("Name: %s\n", order2.name);
        // System.out.printf("Total: %s\n", order2.total);
        // System.out.printf("Ready: %s\n", order2.ready);


        // System.out.printf("Name: %s\n", order3.name);
        // System.out.printf("Total: %s\n", order3.total);
        // System.out.printf("Ready: %s\n", order3.ready);

        // System.out.printf("Name: %s\n", order4.name);
        // System.out.printf("Total: %s\n", order4.total);
        // System.out.printf("Ready: %s\n", order4.ready);
    }
}
