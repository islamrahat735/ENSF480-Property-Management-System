package ensf480.controller;

import ensf480.model.*;
import java.util.ArrayList;

public class LandlordController {
    private dbConnectionController db = new dbConnectionController();

    //gets all properties owned by a landlord
    public ArrayList<Property> getAllProperties(int landlordID) {
        return db.getLandlordProperties(landlordID);
    }

    //gets all suspended properties owned by a landlord - for paying fee
    public ArrayList<Property> getSuspendedProperties(int landlordID) {
        return db.getSuspendedLandlordProperties(landlordID);
    }

    //adds a given property argument to the database
    public void registerProperty(Property property) {
        db.addProperty(property);
    }

    //when a fee is paid, we need to list a property and notify all registered renters
    //functions as a pseudo - observer pattern - since everything is stored in the DB we don't really need to update any objects
    public void notifyRegRenters(Property property) {
        ArrayList<RegisteredRenter> allRenters = db.getAllRenters(); //get all the RegisteredRenters and their search criteria
        for(RegisteredRenter renter : allRenters) { //for each registered renter
            Email email = renter.update(property); //check if the new property matches their criteria and return an email if it does
            if(email != null)
                db.addRenterEmail(renter.getId(), email); //adds the email to the database
        }
    }
}