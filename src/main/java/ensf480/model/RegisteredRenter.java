package ensf480.model;

import java.util.ArrayList;

//observer of the observer pattern, gets updated whenever a new listing is posted
public class RegisteredRenter extends Renter implements ListingObserver {
    private ArrayList<Property> allListings; //what we're observing
    private ArrayList<Property> interestedListings;
    private SearchCriteria notifCriteria; //the user's defined criteria to get notified by
    private boolean isSubscribed = false;

    // public void checkProperty(Property property) {
    //     if(notifCriteria.matchesProperty(property)) {
    //         notify();
    //     }
    // }

    public void update() {
        for(Property property : allListings) {
            
        }
    }
}
