package ensf480;
import java.util.ArrayList;

import ensf480.controller.*;
import ensf480.model.*;
import ensf480.view.*;
import java.awt.EventQueue;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        dbConnectionController db = new dbConnectionController("propertyms", "ensf480", "jdbc:mysql://localhost/propertyms");
        //dbConnectionController db = new dbConnectionController();
        Address address = new Address("university dr.", "NW");
        Property property = new Property("apartment", address, 3, 3, true, 1);
        db.addProperty(property);
        ArrayList<Property> allProperties = db.selectProperties();
        db.deleteProperty(allProperties.get(1));
        System.out.println(allProperties.toString());

        db.close();

    }
}
