package ensf480.controller;
import java.util.ArrayList;

import ensf480.model.*;

//Controls searches involving SearchCriteria
public class SearchCriteriaController {
    private dbConnectionController db = new dbConnectionController();
    
    //searches for properties that match a given SearchCriteria's criteria
    //searches will only take ACTIVE properties into account - used for both
    //Registered and Unregistered Renters (hence its own class)
    public ArrayList<Property> searchProperties(SearchCriteria criteria) {
        ArrayList<Property> propertyList = db.selectActiveProperties(); //gets all active properties

        ArrayList<Property> matchedList = new ArrayList<>();
        for(Property property : propertyList) { //for each active property
            if(property.matchesCriteria(criteria)) { //if it matches the given criteria
                matchedList.add(property); //add it to our result
            }
        }
        return matchedList; //and return our result
    }
    //we only needed one function here but it's good to leave this open for expansion and to make it easy for
    //other user type controllers to pull from
}
