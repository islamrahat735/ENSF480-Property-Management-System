package ensf480.controller;

import ensf480.model.*;
import java.util.ArrayList;

public class ManagerController {

    private dbConnectionController db = new dbConnectionController();

    public ArrayList<Property> getAllProperties(){
        return db.selectProperties();
    }

    public void setFee(float cost, int duration){
        Fee fee = Fee.getInstance();
        fee.setCost(cost);
        fee.setDurationDays(duration);

        db.setFee(fee);
    }
    
}
