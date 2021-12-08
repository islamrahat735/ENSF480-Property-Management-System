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

    public ArrayList<Property> selectActiveProperties(){

        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            Statement myStmt = dbConnection.createStatement();
            resultSet = myStmt.executeQuery("SELECT * FROM property WHERE status = 'ACTIVE'");
            
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
            myStmt.setString(2, property.getType());
            myStmt.setString(3, property.getAddress().getStreet_address());
            myStmt.setString(4, property.getAddress().getQuadrant());
            myStmt.setInt(5, property.getNumBedrooms());
            myStmt.setInt(6, property.getNumBathrooms());
            myStmt.setBoolean(7, property.getIsFurnished());
            myStmt.setInt(8, property.getOwnerId());

            myStmt.executeUpdate();

            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public void updateProperty(Property property){
        try{
            this.createConnection();
            String query = "UPDATE property SET status = ?, type = ?, address = ?, quadrant = ?, bedrooms = ?, bathrooms = ?, isFurnished = ?, ownerId = ? WHERE pid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, property.getStatus());
            myStmt.setString(2, property.getType());
            myStmt.setString(3, property.getAddress().getStreet_address());
            myStmt.setString(4, property.getAddress().getQuadrant());
            myStmt.setInt(5, property.getNumBedrooms());
            myStmt.setInt(6, property.getNumBathrooms());
            myStmt.setBoolean(7, property.getIsFurnished());
            myStmt.setInt(8, property.getOwnerId());
            myStmt.setInt(9, property.getId());

            myStmt.executeUpdate();

            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    public void deleteProperty(Property property){
        try{
            this.createConnection();
            String query = "DELETE FROM property WHERE pid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, property.getId());

            myStmt.executeUpdate();

            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //LANDLORD STUFF

    public Landlord getLandlord(String username, String password){
        Landlord landlord = null;
        try{
            this.createConnection();
            String query = "SELECT * FROM property WHERE username = ? AND password = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, username);
            myStmt.setString(2, password);

            resultSet = myStmt.executeQuery();
            while(resultSet.next()){
                landlord = new Landlord(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("fname"), resultSet.getString("lname"));
                landlord.setId(resultSet.getInt("lid"));
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return landlord;
    }

    public void close() {
        try {
            if(resultSet != null){
                resultSet.close();
            }
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
