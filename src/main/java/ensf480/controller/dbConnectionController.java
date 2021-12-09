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
                property.setStatus(resultSet.getString("status"));
                property.setDateListed(resultSet.getString("listDate"));
                property.setDateRented(resultSet.getString("rentDate"));
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
                property.setStatus(resultSet.getString("status"));
                property.setDateListed(resultSet.getString("listDate"));
                property.setDateRented(resultSet.getString("rentDate"));
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
            String query = "Insert INTO property (status, type, address, quadrant, bedrooms, bathrooms, isFurnished, ownerId, listDate, rentDate ) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, property.getStatus());
            myStmt.setString(2, property.getType());
            myStmt.setString(3, property.getAddress().getStreetAddress());
            myStmt.setString(4, property.getAddress().getQuadrant());
            myStmt.setInt(5, property.getNumBedrooms());
            myStmt.setInt(6, property.getNumBathrooms());
            myStmt.setBoolean(7, property.isFurnished());
            myStmt.setInt(8, property.getOwnerId());
            myStmt.setString(9, property.getdateListed());
            myStmt.setString(10, property.getDateRented());

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
            myStmt.setString(3, property.getAddress().getStreetAddress());
            myStmt.setString(4, property.getAddress().getQuadrant());
            myStmt.setInt(5, property.getNumBedrooms());
            myStmt.setInt(6, property.getNumBathrooms());
            if(property.isFurnished()){
                myStmt.setInt(7, 1);
            }
            else{
                myStmt.setInt(7, 0);
            }
            
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

    public ArrayList<Property> getLandlordProperties( Landlord landlord){
        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            PreparedStatement myStmt = dbConnection.prepareStatement("SELECT * FROM property WHERE ownerId = ?");

            myStmt.setInt(1, landlord.getId());
            resultSet = myStmt.executeQuery();
            
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

    //Manager
    public Manager getManager(String username, String password){
        Manager manager = null;
        try{
            this.createConnection();
            String query = "SELECT * FROM Manager WHERE username = ? AND password = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, username);
            myStmt.setString(2, password);

            resultSet = myStmt.executeQuery();
            while(resultSet.next()){
                manager = new Manager(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("fname"), resultSet.getString("lname"));
                manager.setId(resultSet.getInt("mid"));
            }
            myStmt.close();
            this.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return manager;
    }

    //Search Criteria

    public SearchCriteria getSearchCriteria(RegisteredRenter renter){
        SearchCriteria criteria = null;
        try{
            this.createConnection();
            String query = "SELECT * FROM Search_Criteria WHERE rid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);
            myStmt.setInt(1, renter.getId());

            resultSet = myStmt.executeQuery();

            while(resultSet.next()){
                criteria = new SearchCriteria();
                if(resultSet.getString("isFurnished") != null){
                    if(resultSet.getString("isFurnished").equals("T")){
                        criteria.setIsFurnished(1);
                    }
                    else if(resultSet.getString("isFurnished").equals("F")){
                        criteria.setIsFurnished(0);
                    }
                }
                else{
                    criteria.setIsFurnished(-1);
                }
                if(resultSet.getString("type") != null){
                    criteria.setType(PropertyType.valueOf(resultSet.getString("type").toUpperCase()));
                }
                if(resultSet.getString("quadrant") != null){
                    criteria.setQuadrant(Quadrant.valueOf(resultSet.getString("quadrant").toUpperCase()));
                }
                criteria.setNumBathrooms(resultSet.getInt("bedrooms"));
                criteria.setNumBathrooms(resultSet.getInt("bathrooms"));  
            }
            myStmt.close();
            this.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return criteria;
    }

    // public Fee getFee(){
    //     Fee fee = null;
    //     try{
    //         this.createConnection();
    //     }catch(SQLException e){

    //     }
    //     return fee;
    // }


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
