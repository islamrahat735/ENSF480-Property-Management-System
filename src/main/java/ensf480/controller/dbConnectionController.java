package ensf480.controller;

import java.sql.*;
import java.util.ArrayList;
import ensf480.model.*;

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

    public ArrayList<Property> selectProperties(){

        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            Statement myStmt = dbConnection.createStatement();
            resultSet = myStmt.executeQuery("SELECT * FROM property");
            
            while (resultSet.next()){
                Property property = new Property(resultSet.getString("type"), resultSet.getString("address"), resultSet.getString("quadrant"), resultSet.getInt("bedrooms"),
                 resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                props.add(property);
            }
            
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    public Property addProperty(Property property){
        try{
            this.createConnection();
            String query = "Insert INTO property (status, type, address, quadrant, bedrooms, bathrooms, isFurnished, ownerId) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, property.getStatus());
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
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
