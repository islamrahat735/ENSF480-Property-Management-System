package ensf480.controller;

import java.sql.*;

public class dbConnectionController {
    
    private Connection dbConnection;
    private ResultSet resultSet;

    public dbConnectionController(){   
    }

    public void createConnection(){
                
        try{
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/propertyms", "propertyms", "ensf480");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectProperties(){
        StringBuffer properties = new StringBuffer();
        
        try {                    
            Statement myStmt = dbConnection.createStatement();
            resultSet = myStmt.executeQuery("SELECT * FROM property");
            
            while (resultSet.next()){
                //System.out.println("Print results: " + resultSet.getString("name") + ", " + resultSet.getString("owner"));
                
                properties.append(resultSet.getInt("pid") + ", " + resultSet.getString("quadrant"));
                properties.append('\n');
            }
            
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return properties.toString();
    }

    public void close() {
        try {
            resultSet.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
