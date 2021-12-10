package ensf480.controller;
import java.util.ArrayList;

import ensf480.model.*;

public class PeriodicReportController {
    private dbConnectionController db = new dbConnectionController();


    public PeriodicReport createPeriodicReport(String startDate, String endDate){
        ArrayList<Property> rentedProperties = db.getRentedPropertiesOverPeriod(startDate, endDate);
        ArrayList<Property> listedProperties = db.getlistedPropertiesOverPeriod(startDate, endDate);
        ArrayList<Property> activeProperties = db.selectActiveProperties();

        PeriodicReport result = new PeriodicReport(listedProperties.size(), rentedProperties.size(), activeProperties.size(), rentedProperties);

        return result;

    }
}