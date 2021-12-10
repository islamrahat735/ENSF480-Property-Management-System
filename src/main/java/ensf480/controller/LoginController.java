package ensf480.controller;

import ensf480.model.*;

public class LoginController {
    private dbConnectionController db = new dbConnectionController();

    public boolean loginManager(String username, String password){
        Manager manager = db.getManager(username, password);

        if(manager == null){
            return false;
        }
        
        return true;
    }

    public int loginLandlord(String username, String password){
        Landlord landlord = db.getLandlord(username, password);

        if(landlord == null){
            return -1;
        }
        else{
            return landlord.getId();
        }
    }

    public int loginRenter(String username, String password) {
        RegisteredRenter renter = db.getRegisteredRenter(username, password);

        if(renter == null) 
            return -1;
        else
            return renter.getId();
    }
}
