package ensf480.controller;
import java.util.ArrayList;

import ensf480.model.*;

public class SearchCriteriaController {
    private dbConnectionController db = new dbConnectionController();
        
    public ArrayList<Property> searchProperties(SearchCriteria criteria) {
        ArrayList<Property> propertyList = db.selectActiveProperties();
        ArrayList<Property> matchedList = new ArrayList<>();
        for(Property property : propertyList) {
            if(property.matchesCriteria(criteria)) {
                matchedList.add(property);
            }
        }
        return matchedList;
    }
}
