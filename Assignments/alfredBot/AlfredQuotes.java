import java.time.LocalDateTime;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        String greeting =String.format("Hello %s",name);
        return  greeting ;
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        LocalDateTime myObj = LocalDateTime.now();
        String announcement = String.format("It is cuurently %s",myObj);
        return announcement;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        int isAlexis = conversation.indexOf("Alexis");
        int isAlfred = conversation.indexOf("Alfred");
        if (isAlexis > 0) {
        return "Right away, sir. She certainly isn't sophisticated enough for that.";
    }
    else if (isAlfred>0) {
        return "At your service. As you wish, naturally.";
    }
    else {
        return "Right. And with that I shall retire.";
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!
}
}
