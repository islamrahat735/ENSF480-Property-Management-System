package ensf480.model;

import java.util.ArrayList;

//observer of the observer pattern, gets updated whenever a new listing is posted
public class RegisteredRenter extends Account implements ListingObserver {

    private SearchCriteria notifCriteria; //the user's defined criteria to get notified by
    private ArrayList<Email> inbox = new ArrayList<>();

    public RegisteredRenter(String username, String password, String fname, String lname) {
        super(username, password, fname, lname);
    }

    public void update(Property property) {
        if (property.matchesCriteria(notifCriteria)) {
            String from = "Notification System";
            String title = "A property with your criteria has been posted!";
            String message = property.toString();
            addEmail(new Email(from, title, message));
        }
    }

    //setters and getters
    public void setNotifCriteria(SearchCriteria criteria) {
        this.notifCriteria = criteria;
    }

    public SearchCriteria getNotifCriteria() {
        return notifCriteria;
    }

    public ArrayList<Email> getInbox() {
        return inbox;
    }

    //inbox methods
    public void addEmail(Email email) {
        inbox.add(email);
    }

    public void removeEmail(int index) {
        inbox.remove(index);
    }

    public void clearInbox() {
        inbox.clear();
    }
}