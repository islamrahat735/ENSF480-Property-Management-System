package ensf480.controller;
import java.util.ArrayList;

import ensf480.model.*;

public class PeriodicReportController {
    private dbConnectionController db = new dbConnectionController();


    //creates and returns a PeriodicReport object by calling various queries
    public PeriodicReport createPeriodicReport(String startDate, String endDate){
        ArrayList<Property> rentedProperties = db.getRentedPropertiesOverPeriod(startDate, endDate);
        // System.out.println("\n RENTED PROPERTIES\n");
        // System.out.println(rentedProperties);

        ArrayList<Property> listedProperties = db.getlistedPropertiesOverPeriod(startDate, endDate);
        // System.out.println("\n listed PROPERTIES\n");
        // System.out.println(listedProperties);
        ArrayList<Property> activeProperties = db.selectActiveProperties();
        // System.out.println("\n active PROPERTIES\n");
        // System.out.println(activeProperties);

        PeriodicReport result = new PeriodicReport(listedProperties.size(), rentedProperties.size(), activeProperties.size(), rentedProperties);

        return result;

    }
}