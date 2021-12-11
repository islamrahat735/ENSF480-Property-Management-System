package ensf480.controller;

import ensf480.model.*;
import java.util.ArrayList;

//Controls functions of the RegisteredRenter - in particular subscribing and unsubscribing
public class RegRenterController {
    private dbConnectionController db = new dbConnectionController();
    
    //uses SearchCriteriaController to search for properties
    public ArrayList<Property> searchProperties(SearchCriteria criteria) {
        SearchCriteriaController scc = new SearchCriteriaController();
        ArrayList<Property> result = scc.searchProperties(criteria);
        return result;
    }

    public ArrayList<RegisteredRenter> getAllRenters(){
        return db.getAllRenters();
    }

    //Subscribes a renter to a given SearchCriteria
    public void subscribe(int renterID, SearchCriteria notifCriteria) {
        SearchCriteria renterCriteria = db.getSearchCriteria(renterID);
        System.out.println(renterCriteria);
        if(renterCriteria == null) //if they aren't already subscribed,
            db.addSearchCriteria(notifCriteria); //add a new criteria to the db
        else
            db.setSearchCriteria(notifCriteria); //otherwise, replace their existing criteria in the db
    }

    //Unsubscribes a renter from any SearchCriteria
    public void unsubscribe(int renterID) {
        db.deleteSearchCriteria(renterID);
    }

    public ArrayList<Email> getInbox(int renterID) {
        return db.getRenterInbox(renterID);
    }
}
