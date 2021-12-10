package ensf480.model;
import java.util.ArrayList;

//Registered Renter account
//observer pattern, gets updated whenever a new listing is posted
public class RegisteredRenter extends Account implements ListingObserver {

    private int id;

    private SearchCriteria notifCriteria; //the user's defined criteria to get notified by


    public RegisteredRenter(String username, String password, String fname, String lname) {
        super(username, password, fname, lname);
        notifCriteria = null;
    }

    //update function that is called whenever a new property is listed
    public Email update(Property property) {
        //if the user is subscribed to some sort of criteria and the property matches their criteria
        if(notifCriteria != null && property.matchesCriteria(notifCriteria)) {
            //create and return an email to send them
            String from = "Notification System";
            String title = "A property with your criteria has been posted!";
            String message = property.toString();
            return new Email(from, title, message); 
        }
        return null; //if it doesn't match their criteria, returns null
    }

    //setters and getters
    public void setNotifCriteria(SearchCriteria criteria) {
        this.notifCriteria = criteria;
    }

    public SearchCriteria getNotifCriteria() {
        return notifCriteria;
    }

    public int getId() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
}