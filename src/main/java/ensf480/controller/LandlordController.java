package ensf480.controller;

import ensf480.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

//Controller that controls the Landlord functionalities/use cases
public class LandlordController {
    private dbConnectionController db = new dbConnectionController();
    
    //gets all properties owned by a landlord
    public ArrayList<Property> getAllProperties(int landlordID) {
        return db.getLandlordProperties(landlordID);
    }

    public Property getProperty(int propertyID) {
        return db.getProperty(propertyID);
    }

    //gets all suspended properties owned by a landlord - for paying fee
    public ArrayList<Property> getSuspendedProperties(int landlordID) {
        return db.getSuspendedLandlordProperties(landlordID);
    }

    //adds a given property argument to the database
    public void registerProperty(Property property) {
        db.addProperty(property);
    }

    //when a fee is paid, updates a property's listing and notifies everyone
    public void listProperty(Property property) {
        property.setDateListed(LocalDate.now().toString());
        property.setStatus("ACTIVE");
        db.updateProperty(property);
        this.notifyRegRenters(property);
    }

    //functions as a pseudo - observer pattern - since everything is stored in the DB we don't really need to update any objects
    //whenever a property is listed all renters w/ criteria are notified
    public void notifyRegRenters(Property property) {
        ArrayList<SearchCriteria> allNotifCriteria = db.getAllSearchCriteria(); //get all the RegisteredRenters and their search criteria
        for(SearchCriteria criteria : allNotifCriteria) { //for each registered renter
            Email email = criteria.checkIfNotify(property); //check if the new property matches their criteria and return an email if it does
            if(email != null)
                db.addRenterEmail(criteria.getRenterID(), email); //adds the email to the database
        }
    }

    public Fee getFee(){
        return db.getFee();
    }

    public void updatePropertyStatus(Property property, String status) {
        String prevStatus = property.getStatus();
        property.setStatus(status); //updates the property object's status

        //if we change it to rented and it wasn't rented before
        if(status == "RENTED") {
            property.setDateRented(LocalDate.now().toString()); //add a date rented
        }

        db.updateProperty(property); //updates the DB to reflect this change
    }

    public ArrayList<Email> getInbox(int landlordID) {
        return db.getLandlordInbox(landlordID);
    }
}