package ensf480.controller;

import ensf480.model.*;

public class LoginController {
    private dbConnectionController db = new dbConnectionController("propertyms", "ensf480", "jdbc:mysql://localhost/propertyms");

    public boolean loginManager(String username, String password){
        Manager manager = db.getManager(username, password);

        if(manager == null){
            return false;
        }
        
        return true;
    }
}
