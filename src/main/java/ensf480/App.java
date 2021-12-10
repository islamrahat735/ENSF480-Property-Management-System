package ensf480;
import java.util.ArrayList;

import ensf480.controller.*;
import ensf480.model.*;
import ensf480.view.*;
import java.awt.EventQueue;

import java.time.LocalDate;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        dbConnectionController db = new dbConnectionController("propertyms", "ensf480", "jdbc:mysql://localhost/propertyms");
        // //dbConnectionController db = new dbConnectionController();
        Address address = new Address("saddleRidge dr", "NE");
        Property property = new Property("apartment", address, 2, 3, true, 1);
        property.setStatus("ACTIVE");
        property.setdateListed(LocalDate.now().toString());
        db.addProperty(property);
        ArrayList<Property> allProperties = db.selectProperties();
        
        // //db.deleteProperty(allProperties.get(1));
        //System.out.println(allProperties.toString());

        PeriodicReportController periodicReportController = new PeriodicReportController();
        System.out.println(periodicReportController.createPeriodicReport("2021-12-08", "2021-12-09"));

        LoginController login = new LoginController();
        System.out.println(login.loginManager("manager@manager.com", "pass"));

        

    }
}
