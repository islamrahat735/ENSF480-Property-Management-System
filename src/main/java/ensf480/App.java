package ensf480;
import java.util.ArrayList;

import ensf480.controller.*;
import ensf480.model.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        dbConnectionController db = new dbConnectionController();

        db.createConnection();

        ArrayList<Property> allProperties = db.selectProperties();
        System.out.println(allProperties.toString());

        db.close();
    }
}
