package ensf480.controller;

import ensf480.model.*;
import java.util.ArrayList;

//Controls functions of the Renters emailing a Landlord
public class RenterEmailLandlordController {
    private dbConnectionController db = new dbConnectionController();

    public void emailRenter(int landlordID, String from, String title, String message) {
        Email email = new Email(from, title, message);
        db.addLandlordEmail(landlordID, email);
    }

    public int getLandlordOf(int propertyID) {
        return db.getProperty(propertyID).getOwnerId();
    }
}