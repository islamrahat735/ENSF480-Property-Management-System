package ensf480.model;

//observer of the observer pattern, gets updated whenever a new listing is posted
public class RegisteredRenter extends Account implements ListingObserver {

    private int id;

    private SearchCriteria notifCriteria; //the user's defined criteria to get notified by
    private Inbox inbox;

    public RegisteredRenter(String username, String password, String fname, String lname) {
        super(username, password, fname, lname);
        inbox = new Inbox();
        notifCriteria = null;
    }

    public void update(Property property) {
        if(notifCriteria != null) {
            if (property.matchesCriteria(notifCriteria)) {
                String from = "Notification System";
                String title = "A property with your criteria has been posted!";
                String message = property.toString();
                inbox.addEmail(new Email(from, title, message));
            }
        }
    }

    //setters and getters
    public void setNotifCriteria(SearchCriteria criteria) {
        this.notifCriteria = criteria;
    }

    public SearchCriteria getNotifCriteria() {
        return notifCriteria;
    }

    public Inbox getInbox() {
        return inbox;
    }

    public int getId() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
}