package ensf480.controller;

import ensf480.model.*;

//Controls Login functionalities
//nice and open to extension :)
public class LoginController {
    private dbConnectionController db = new dbConnectionController();

    //Checks if a Manager's username/password exists in the DB and returns a boolean value
    //returns true if manager is found, allowing login to be successful
    //we don't need the manager's ID in this case so we just use boolean
    public boolean loginManager(String username, String password){
        Manager manager = db.getManager(username, password); //checks DB for account

        if(manager == null){ //if not found, return false
            return false;
        }
        else{ //if found, return true
            return true;
        }
    }

    //Checks if a landlord's username/password exists in the DB and returns their ID
    //returns -1 if they aren't found, indicating unsuccessful login
    public int loginLandlord(String username, String password){
        Landlord landlord = db.getLandlord(username, password); //checks DB for account

        if(landlord == null){ //if not found, return -1 (fail)
            return -1;
        }
        else{ //if found, return their ID
            return landlord.getId();
        }
    }

    //Checks if a landlord's username/password exists in the DB and returns their ID
    //returns -1 if they aren't found, indicating unsuccessful login
    public int loginRenter(String username, String password) {
        RegisteredRenter renter = db.getRegisteredRenter(username, password); //checks DB for account

        if(renter == null) //if not found, return -1 (fail)
            return -1;
        else {
            return renter.getId(); //if found, return their ID
        }
    }

    //Adds a renter to the DB with argument credentials
    public void registerRenter(String username, String password, String fname, String lname) {
        db.addRegisteredRenter(username, password, fname, lname);
    }
}
