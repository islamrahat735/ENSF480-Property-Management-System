package ensf480.controller;

import ensf480.model.*;
import java.util.ArrayList;

public class RegRenterController {
    private dbConnectionController db = new dbConnectionController();

    public ArrayList<Property> searchProperties(SearchCriteria criteria) {
        SearchCriteriaController scc = new SearchCriteriaController();
        ArrayList<Property> result = scc.searchProperties(criteria);
        return result;
    }

    public void subscribe(int renterID, SearchCriteria notifCriteria) {
        RegisteredRenter renter = db.getRegisteredRenter(renterID); //gets the renter with the ID
        if(renter.getNotifCriteria() == null) //if they aren't already subscribed
            db.addSearchCriteria(notifCriteria); //add a new criteria to the db
        else
            db.setSearchCriteria(notifCriteria); //otherwise, replace their existing criteria in the db
    }

    public void unsubscribe(int renterID) {
        db.deleteSearchCriteria(renterID);
    }
}
