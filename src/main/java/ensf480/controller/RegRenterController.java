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

    ///public void subscribe(RegisteredRenter renterSearchCriteria criteria) {
        
    //}
}
