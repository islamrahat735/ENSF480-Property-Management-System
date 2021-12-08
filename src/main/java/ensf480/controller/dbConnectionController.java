package ensf480.controller;

import java.sql.*;
import java.util.ArrayList;
import ensf480.model.*;

public class dbConnectionController {
    private final String USERNAME;
    private final String PASSWORD;
    private final String URL;
    
    private Connection dbConnection;
    private ResultSet resultSet;

    public dbConnectionController(String username, String password, String url) {
        this.USERNAME = username;
        this.PASSWORD = password;
        this.URL = url;   
    }

    public void createConnection() {
        try{
            dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
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

    public void addProperty(Property property){
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
