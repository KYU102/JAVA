import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello, " + name;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "The Current Date is: " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") > -1){
            return "Right way sir. She certainly isn't sophistcated enough for that";
        }
        else if(conversation.indexOf("Alfred") > -1){
            return "At your servce. As you wish, naturally";
        }
        else{
            return "right and with that I shall retire.";
        }
    
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

