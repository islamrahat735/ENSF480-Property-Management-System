package ensf480.controller;

import ensf480.model.*;
import java.util.ArrayList;

public class ManagerController {

    private dbConnectionController db = new dbConnectionController("propertyms", "ensf480", "jdbc:mysql://localhost/propertyms");

    public ArrayList<Property> getAllProperties(){
        return db.selectProperties();
    }

    public void setFee(int fee, int duration){
        
    }
    
}
