public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 4.5;
        double lattePrice = 6;
        double cappuccinoPrice = 5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(pendingMessage);
        System.out.println(generalGreeting + customer4);
        if(isReadyOrder4){
            System.out.println(readyMessage);
            System.out.println(cappuccinoPrice);
        }
        else{
            System.out.println(pendingMessage);
        }
        System.out.println(generalGreeting + customer2);
        System.out.println(lattePrice*2);
        if(isReadyOrder2){
            System.out.println(readyMessage);
        }
        else{
            System.out.println(pendingMessage);
        }
        System.out.println(generalGreeting + customer3);
        System.out.println(lattePrice-dripCoffeePrice);
    	// ** Your customer interaction print statements will go here ** //
    }
}
