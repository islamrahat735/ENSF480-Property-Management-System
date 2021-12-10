package ensf480.controller;

import ensf480.model.*;
import java.util.ArrayList;

//controller that performs functionalities of a Manager
public class ManagerController {

    private dbConnectionController db = new dbConnectionController();

    //returns an ArrayList of all properties in DB in the form of objects
    public ArrayList<Property> getAllProperties(){
        return db.selectProperties();
    }

    //returns an ArrayList of all landlords in DB in the form of objects
    public ArrayList<Landlord> getAllLandlords() {
        //return db.selectLandlords(); //need to implement
        return null; //placeholder
    }

    //returns an ArrayList of all renters in DB in the form of objects
    public ArrayList<RegisteredRenter> getAllRenters() {
        return db.getAllRenters();
    }

    //Sets a new fee cost and duration
    //error checking on arguments is done in the view
    public void setFee(float cost, int duration){
        Fee fee = Fee.getInstance(); //gets the fee's instance (or makes one if needed)
        fee.setCost(cost); //sets the fee's cost
        fee.setDurationDays(duration); //sets the fee's duration (period)

        db.setFee(fee); //updates the fee stored in the database
    }
    
}
