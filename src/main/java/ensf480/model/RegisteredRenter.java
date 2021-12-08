package ensf480.model;

import java.util.ArrayList;

//observer of the observer pattern, gets updated whenever a new listing is posted
public class RegisteredRenter extends Account implements ListingObserver {

    private int id;

    private SearchCriteria notifCriteria; //the user's defined criteria to get notified by
    private ArrayList<Email> inbox = new ArrayList<>();

    public RegisteredRenter(String username, String password, String fname, String lname) {
        super(username, password, fname, lname);
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SearchCriteria getNotifCriteria() {
        return this.notifCriteria;
    }

    public void setNotifCriteria(SearchCriteria notifCriteria) {
        this.notifCriteria = notifCriteria;
    }

    public ArrayList<Email> getInbox() {
        return this.inbox;
    }

    public void setInbox(ArrayList<Email> inbox) {
        this.inbox = inbox;
    }




    public void addEmail(Email email) {
        inbox.add(email);
    }

    public void removeEmail(int index) {
        inbox.remove(index);
    }

    public void clearInbox() {
        inbox.clear();
    }

    public void subscribe(SearchCriteria notifCriteria) {
        this.notifCriteria = notifCriteria;
    }

    public void unsubscribe() {
        notifCriteria = null;
    }

    public void update() {
        
    }
}