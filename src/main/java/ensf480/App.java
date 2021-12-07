package ensf480;
import ensf480.controller.*;
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

        String allPropertiesString = db.selectProperties();
        System.out.println(allPropertiesString);

        db.close();
    }
}
