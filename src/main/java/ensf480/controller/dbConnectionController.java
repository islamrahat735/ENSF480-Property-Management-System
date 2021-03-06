package ensf480.controller;

import java.sql.*;
import java.util.ArrayList;
import ensf480.model.*;

//Controller class that interacts with the database
//All the other controllers use an object of this class to make queries
public class dbConnectionController {
    //the credentials used to log in to the database
    private final String USERNAME;
    private final String PASSWORD;
    private final String URL;
    
    private Connection dbConnection; //the connection to the db
    private ResultSet resultSet; //the results from any query we do

    //constructor that determines the connection credentials
    //change this if you want to change the account/url that you connect with
    public dbConnectionController() {
        this.USERNAME = "propertyms";
        this.PASSWORD = "ensf480";
        this.URL = "jdbc:mysql://localhost/propertyms";
    }

    //connects to the MySQL db
    public void createConnection() {
        try{
            dbConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //closes the dbConnections
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


//--------------------PROPERTIES--------------------------

    //returns an ArrayList of all properties stored in the database
    public ArrayList<Property> selectProperties(){
        ArrayList<Property> props = new ArrayList<>();
        
        try {
            //creates and runs simple query
            this.createConnection();                    
            Statement myStmt = dbConnection.createStatement();
            resultSet = myStmt.executeQuery("SELECT * FROM property");
            
            //stores the results of the query by creating Property objects and storing them in an ArrayList
            while (resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                //check if listDate is null
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                //check if rentDate is null
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
                
                props.add(property);
            }
            
            //close connections
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    //returns an ArrayList of all active properties in the db
    public ArrayList<Property> selectActiveProperties(){

        ArrayList<Property> props = new ArrayList<>();
        
        try {
            //creates and runs simple query
            this.createConnection();                    
            Statement myStmt = dbConnection.createStatement();
            resultSet = myStmt.executeQuery("SELECT * FROM property WHERE status = 'ACTIVE'");
            
            //creates Property object for each result
            while (resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
                props.add(property);
            }

            //closes connections
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    //adds a property to the database
    public void addProperty(Property property){
        try{
            //creates a query
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

            //checks for null
            if(property.getDateListed() != null){
                myStmt.setDate(9, Date.valueOf(property.getdateListed()));
            }
            else{
                myStmt.setDate(9, null);
            }
            
            //checks for null
            if(property.getDateRented() != null){
                myStmt.setDate(10, Date.valueOf(property.getDateRented()));
            }
            else{
                myStmt.setDate(10, null);
            }
            
            //runs the update query
            myStmt.executeUpdate();

            //closes connection
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //get single Property
    public Property getProperty(int propertyID) {
        Property property = null;
        try{
            //creates the query
            this.createConnection();
            String query = "SELECT * FROM property WHERE pid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);
            myStmt.setInt(1, propertyID);

            //runs the query
            resultSet = myStmt.executeQuery();

            //returns the result
            while(resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
            }
            //closes connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
        return property;
    }
    

    //updates a property in the database
    public void updateProperty(Property property){
        try{
            //creates query using fields of property
            this.createConnection();
            String query = "UPDATE property SET status = ?, type = ?, address = ?, quadrant = ?, bedrooms = ?, bathrooms = ?, isFurnished = ?, ownerId = ?, listDate = ?, rentDate = ? WHERE pid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, property.getStatus());
            myStmt.setString(2, property.getType());
            myStmt.setString(3, property.getAddress().getStreetAddress());
            myStmt.setString(4, property.getAddress().getQuadrant());
            myStmt.setInt(5, property.getNumBedrooms());
            myStmt.setInt(6, property.getNumBathrooms());

            //converts boolean to int
            if(property.isFurnished()){
                myStmt.setInt(7, 1);
            }
            else{
                myStmt.setInt(7, 0);
            }
            
            myStmt.setInt(8, property.getOwnerId());

            //checks for null
            if(property.getDateListed() != null){
                myStmt.setDate(9, Date.valueOf(property.getdateListed())); //woops typo
            }
            else{
                myStmt.setDate(9, null);
            }
            
            //checks for null
            if(property.getDateRented() != null){
                myStmt.setDate(10, Date.valueOf(property.getDateRented()));
            }
            else{
                myStmt.setDate(10, null);
            }

            myStmt.setInt(11, property.getId());
            
            //runs the query
            myStmt.executeUpdate();

            //closes the connection
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //deletes a property from the database
    public void deleteProperty(Property property){
        try{
            //creates query
            this.createConnection();
            String query = "DELETE FROM property WHERE pid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, property.getId());

            //runs query
            myStmt.executeUpdate();

            //closes connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

//--------------------LANDLORDS--------------------------

    public ArrayList<Landlord> getAllLandlords(){
        ArrayList<Landlord> landlords = new ArrayList<>();
        try{
            this.createConnection();
            String query = "SELECT * FROM landlord ";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);


            resultSet = myStmt.executeQuery();
            while(resultSet.next()){
            
                Landlord landlord = new Landlord(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("fname"), resultSet.getString("lname"));
                landlord.setId(resultSet.getInt("lid"));
                landlords.add(landlord);
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return landlords;

    }

    //returns a Landlord object from the db given an account username and password
    public Landlord getLandlord(String username, String password){
        Landlord landlord = null;
        try{
            this.createConnection();
            String query = "SELECT * FROM landlord WHERE username = ? AND password = ?";
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

    //returns an ArrayList of properties owned by a landlord
    public ArrayList<Property> getLandlordProperties(int landlordID){
        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            PreparedStatement myStmt = dbConnection.prepareStatement("SELECT * FROM property WHERE ownerId = ?");

            myStmt.setInt(1, landlordID);
            resultSet = myStmt.executeQuery();
            
            while (resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
                props.add(property);
            }
            
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    //returns an ArrayList of suspended properties owned by a landlord
    public ArrayList<Property> getSuspendedLandlordProperties(int landlordID){
        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            PreparedStatement myStmt = dbConnection.prepareStatement("SELECT * FROM property WHERE ownerId = ? AND status = ?");

            myStmt.setInt(1, landlordID);
            myStmt.setString(2, "SUSPENDED");
            resultSet = myStmt.executeQuery();
            
            while (resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
                props.add(property);
            }
            
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }

     //returns an ArrayList of active properties owned by a landlord
     public ArrayList<Property> getActiveLandlordProperties(int landlordID){
        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            PreparedStatement myStmt = dbConnection.prepareStatement("SELECT * FROM property WHERE ownerId = ? AND status = ?");

            myStmt.setInt(1, landlordID);
            myStmt.setString(2, "ACTIVE");
            resultSet = myStmt.executeQuery();
            
            while (resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
                props.add(property);
            }
            
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }


//--------------------MANAGER--------------------------

    //returns a Manager object from the db given an account username and password
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

//--------------------REGISTERED RENTER--------------------------

    //returns a RegisteredRenter object from the db given an account username and password
    public RegisteredRenter getRegisteredRenter(String username, String password){
        RegisteredRenter renter = null;
        try{
            this.createConnection();
            String query = "SELECT * FROM Registered_Renter WHERE username = ? AND password = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, username);
            myStmt.setString(2, password);

            resultSet = myStmt.executeQuery();
            while(resultSet.next()){
                renter = new RegisteredRenter(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("fname"), resultSet.getString("lname"));
                renter.setID(resultSet.getInt("rid"));
                //renter.setNotifCriteria(this.getSearchCriteria(renter.getId()));
            }
            myStmt.close();
            this.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return renter;
    }


    //returns a RegisteredRenter object from the db given an id
    public RegisteredRenter getRegisteredRenter(int renterID){
        RegisteredRenter renter = null;
        try{
            //creates a query
            this.createConnection();
            String query = "SELECT * FROM Registered_Renter WHERE rid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, renterID);

            //executes query
            resultSet = myStmt.executeQuery();
            //uses the result to create a new Renter
            while(resultSet.next()){
                renter = new RegisteredRenter(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("fname"), resultSet.getString("lname"));
                renter.setID(renterID);
            }
            //closes connections
            myStmt.close();
            this.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return renter;
    }

    //returns all RegisteredRenters from the db
    public ArrayList<RegisteredRenter> getAllRenters() {
        ArrayList<RegisteredRenter> allRenters = new ArrayList<>();   
        try {
            //creates and executes a simple query
            this.createConnection();                    
            Statement myStmt = dbConnection.createStatement();
            resultSet = myStmt.executeQuery("SELECT * FROM Registered_Renter");
            
            //for each result
            while (resultSet.next()){
                //create a new RegisteredRenter with its fields
                RegisteredRenter renter = new RegisteredRenter(resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("fname"), resultSet.getString("lname"));
                renter.setID(resultSet.getInt("rid"));
                //and add the final renter to the ArrayList
                allRenters.add(renter);
            }
            
            //close connections
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allRenters;
    }

    //adds a Registered Renter to the DB
    //will throw SQLException if username already exists
    public void addRegisteredRenter(String username, String password, String fname, String lname) {
         try{
             //creates the query
            this.createConnection();
            String query = "Insert INTO Registered_Renter (username, password, fname, lname) VALUES (?,?,?,?)";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setString(1, username);
            myStmt.setString(2, password);
            myStmt.setString(3, fname);
            myStmt.setString(4, lname);  
            
            //runs the query
            myStmt.executeUpdate();

            //closes the connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

//--------------------SEARCH CRITERIA--------------------------

    //returns a registered renter's search criteria from the db
    public SearchCriteria getSearchCriteria(int renterID){
        SearchCriteria criteria = null;
        try{
            //creates the query
            this.createConnection();
            String query = "SELECT * FROM Search_Criteria WHERE rid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);
            myStmt.setInt(1, renterID);

            //runs the query
            resultSet = myStmt.executeQuery();

            //creates a new SearchCriteria object for each result
            while(resultSet.next()){
                criteria = new SearchCriteria(renterID);
                //converts char/string to int for our purposes
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

                //checks for null
                if(resultSet.getString("type") != null){
                    criteria.setType(PropertyType.valueOf(resultSet.getString("type").toUpperCase()));
                }
                //checks for null
                if(resultSet.getString("quadrant") != null){
                    criteria.setQuadrant(Quadrant.valueOf(resultSet.getString("quadrant").toUpperCase()));
                }
                criteria.setNumBathrooms(resultSet.getInt("bedrooms"));
                criteria.setNumBathrooms(resultSet.getInt("bathrooms"));  
                criteria.setRenterID(resultSet.getInt("rid"));
            }

            //closes connections
            myStmt.close();
            this.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return criteria;
    }

    //gets all search criteria
    public ArrayList<SearchCriteria> getAllSearchCriteria() {
        ArrayList<SearchCriteria> searchList = new ArrayList<>();   
        try {
            //creates and executes a simple query
            this.createConnection();                    
            Statement myStmt = dbConnection.createStatement();
            resultSet = myStmt.executeQuery("SELECT * FROM Search_Criteria");
            
            //for each result
            while (resultSet.next()){
                //create a new RegisteredRenter with its fields
                SearchCriteria criteria = new SearchCriteria(resultSet.getInt("rid"));
                //check if type is null
                if(resultSet.getString("type") != null)
                    criteria.setType(PropertyType.valueOf(resultSet.getString("type")));
                //check if quadrant is null
                if(resultSet.getString("quadrant") != null)
                    criteria.setQuadrant(Quadrant.valueOf(resultSet.getString("quadrant")));
                criteria.setNumBedrooms(resultSet.getInt("bedrooms"));
                criteria.setNumBathrooms(resultSet.getInt("bathrooms"));
                //convert isFurnished char to int
                String isF = resultSet.getString("isFurnished");
                if(isF == null)
                    criteria.setIsFurnished(-1);
                else if(isF.equals("T"))
                    criteria.setIsFurnished(1);
                else if(isF.equals("F"))
                    criteria.setIsFurnished(0);
                //and add the final renter to the ArrayList
                searchList.add(criteria);
            }
            
            //close connections
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return searchList;
    }

    //updates a user's search criteria in the db
    public void setSearchCriteria(SearchCriteria criteria) {
        try {
            //creates query
            this.createConnection();
            String sql = "UPDATE Search_Criteria SET type = ?, quadrant = ?, bedrooms = ?,"
                    + "bathrooms = ?, isFurnished = ? WHERE rid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(sql);
            
            myStmt.setString(1, criteria.getType());

            //checks for null
            if(criteria.getQuadrant() == null)
                myStmt.setString(2, null);
            else
                myStmt.setString(2, criteria.getQuadrant().toString());

            myStmt.setInt(3, criteria.getNumBedrooms());
            myStmt.setInt(4, criteria.getNumBathrooms());
            int isF = criteria.getIsFurnished(); //is furnished

            //converts int to char for purposes of database
            if(isF == -1)
                myStmt.setString(5, null);
            else if(isF == 0)
                myStmt.setString(5, "F");
            else if(isF == 1)
                myStmt.setString(5, "T");
            myStmt.setInt(6, criteria.getRenterID());

            //executes update
            myStmt.executeUpdate();

            //closes connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //deletes a user's search criteria (unsubscribe)
    public void deleteSearchCriteria(int renterId){
        try{
            //creates query
            this.createConnection();
            String query = "DELETE FROM Search_Criteria WHERE rid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, renterId);

            //runs query
            myStmt.executeUpdate();

            //closes connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //adds search criteria to the database from a given SearchCriteria object
    public void addSearchCriteria(SearchCriteria criteria) {
        try{
            //creates a query to insert a Search_Criteria tuple
            this.createConnection();
            String query = "Insert INTO Search_Criteria (rid, type, quadrant, bedrooms, bathrooms, isFurnished) VALUES(?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, criteria.getRenterID());
            myStmt.setString(2, criteria.getType());
            //getQuadrant returns the Quadrant which we need as a string so we have to check here
            if(criteria.getQuadrant() != null)
                myStmt.setString(3, criteria.getQuadrant().toString().toUpperCase());
            else
                myStmt.setString(3, null);
            myStmt.setInt(4, criteria.getNumBedrooms());
            myStmt.setInt(5, criteria.getNumBathrooms());
            //we need to convert isFurnished(int) to a char
            if(criteria.getIsFurnished() == 1)
                myStmt.setString(6, "T");
            else if(criteria.getIsFurnished() == 0)
                myStmt.setString(6, "F");
            else
                myStmt.setString(6, null);
            
            //runs the query
            myStmt.executeUpdate();

            //closes the connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

//--------------------FEE--------------------------

    //gets the fee from the database
    public Fee getFee(){
        Fee fee = null;
        try{
            //creates query
            this.createConnection();
            String sql = "SELECT * FROM Fee";
            PreparedStatement myStmt = dbConnection.prepareStatement(sql);

            //runs query
            resultSet = myStmt.executeQuery();

            //creates a fee object for the result
            while(resultSet.next()){
                fee = Fee.getInstance();
                fee.setCost(resultSet.getFloat("fee"));
                fee.setDurationDays(resultSet.getInt("durationInDays"));
            }

            //closes the connections
            myStmt.close();
            this.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return fee;
    }

    //updates the fee in the database
    public void setFee(Fee fee){
        try{
            //creates query
            this.createConnection();
            String sql = "UPDATE Fee SET fee = ?, durationInDays = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(sql);

            //updates to the fields in the given Fee object
            myStmt.setFloat(1, fee.getCost());
            myStmt.setInt(2, fee.getDurationDays());

            //runs query
            myStmt.executeUpdate();
            
            //closes connections
            myStmt.close();
            this.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

//--------------------EMAIL--------------------------

    //gets all emails attached to a Renter from the DB
    public ArrayList<Email> getRenterInbox(int renterID) {
        ArrayList<Email> inbox = new ArrayList<>();
        try{
            //creates a query that returns all emails belonging to a renter
            this.createConnection();
            String query = "SELECT * FROM R_Inbox WHERE rid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, renterID);
            
            //executes the query
            resultSet = myStmt.executeQuery();

            //stores the results in an arraylist
            while(resultSet.next()){
                inbox.add(new Email(resultSet.getString("ufrom"), resultSet.getString("title"), resultSet.getString("msg")));
            }
            //closes connections
            myStmt.close();
            this.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return inbox;
    }

    //Adds an email to the Renter Inbox Database
    public void addRenterEmail(int renterID, Email email) {
        try{
            //creates a query that inserts an email tied to the renterID
            this.createConnection();
            String query = "Insert INTO R_Inbox (rid, ufrom, title, msg) VALUES(?,?,?,?)";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, renterID);
            myStmt.setString(2, email.getFrom());
            myStmt.setString(3, email.getTitle());
            myStmt.setString(4, email.getMessage());

            //runs the query
            myStmt.executeUpdate();

            //closes the connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    //gets all emails attached to a Landlord from the DB
    public ArrayList<Email> getLandlordInbox(int landlordID) {
        ArrayList<Email> inbox = new ArrayList<>();
        try{
            //creates a query that returns all emails belonging to a landlord
            this.createConnection();
            String query = "SELECT * FROM L_Inbox WHERE lid = ?";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);
            myStmt.setInt(1, landlordID);

            //runs the query
            resultSet = myStmt.executeQuery();

            //stores the results of the query in an arraylist
            while(resultSet.next()){
                inbox.add(new Email(resultSet.getString("ufrom"), resultSet.getString("title"), resultSet.getString("msg")));
            }
            //closes the connections
            myStmt.close();
            this.close();
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return inbox;
    }

    //Adds an email to the Landlord Inbox Database
    public void addLandlordEmail(int landlordID, Email email) {
        try{
            //creates a query that inserts an email tied to the landlordID
            this.createConnection();
            String query = "Insert INTO L_Inbox (lid, ufrom, title, msg) VALUES(?,?,?,?)";
            PreparedStatement myStmt = dbConnection.prepareStatement(query);

            myStmt.setInt(1, landlordID);
            myStmt.setString(2, email.getFrom());
            myStmt.setString(3, email.getTitle());
            myStmt.setString(4, email.getMessage());

            //runs the query
            myStmt.executeUpdate();

            //closes the connections
            myStmt.close();
            this.close();
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }
    
//--------------------PERIODIC REPORT--------------------------

    public ArrayList<Property> getlistedPropertiesOverPeriod(String startDate, String endDate){
        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            PreparedStatement myStmt = dbConnection.prepareStatement("SELECT * FROM property WHERE listDate >= ? and listDate <= ?");
            myStmt.setDate(1, Date.valueOf(startDate));
            myStmt.setDate(2, Date.valueOf(endDate));
            
            resultSet = myStmt.executeQuery();
            
            while (resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
                
                props.add(property);
            }
            
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }

    public ArrayList<Property> getRentedPropertiesOverPeriod(String startDate, String endDate){
        ArrayList<Property> props = new ArrayList<>();
        
        try {
            this.createConnection();                    
            PreparedStatement myStmt = dbConnection.prepareStatement("SELECT * FROM property WHERE rentDate >= ? and rentDate <= ?");
            myStmt.setDate(1, Date.valueOf(startDate));
            myStmt.setDate(2, Date.valueOf(endDate));
            
            resultSet = myStmt.executeQuery();
            
            while (resultSet.next()){
                Address address = new Address(resultSet.getString("address"), resultSet.getString("quadrant"));
                Property property = new Property(resultSet.getString("type"), address, resultSet.getInt("bedrooms"),
                resultSet.getInt("bathrooms"), resultSet.getBoolean("isFurnished"), resultSet.getInt("ownerId"));
                property.setId(resultSet.getInt("pid"));
                property.setStatus(resultSet.getString("status"));
                if(resultSet.getDate("listDate") != null){
                    property.setDateListed(resultSet.getDate("listDate").toString());
                }
                if(resultSet.getDate("rentDate") != null){
                    property.setDateRented(resultSet.getDate("rentDate").toString());
                }
                
                props.add(property);
            }
            
            myStmt.close();
            this.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
