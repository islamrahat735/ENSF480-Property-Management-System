package ensf480.model;

//represents the Search Criteria of a property search
//or the notification criteria of a Registered Renter
public class SearchCriteria {
    //private String city;
    
    //SearchCriteria stores a bunch of different attributes that are optional
    private int renterID; //represents the renter the criteria is tied to in the DB
    
    //all these fields are optional and can be null/-1 to indicate that we don't care
    private PropertyType type;
    private int numBedrooms;
    private int numBathrooms;
    private int isFurnished;

    private Quadrant quadrant;

    //starts with all criteria empty
    public SearchCriteria(int id) {
        renterID = id;
        type = null;
        numBedrooms = -1;
        numBathrooms = -1;
        isFurnished = -1;
        quadrant = null;
    }

    public Email checkIfNotify(Property property) {
        //if the user is subscribed to some sort of criteria and the property matches their criteria
        if(property.matchesCriteria(this)) {
            //create and return an email to send them
            String from = "Notification System";
            String title = "A property with your criteria has been posted!";
            String message = property.toString();
            return new Email(from, title, message); 
        }
        return null; //if it doesn't match their criteria, returns null
    }

    //getters/setters
    public String getType() {
        if(this.type != null)
            return this.type.toString();
        else
            return null;
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public int getNumBedrooms() {
        return this.numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBathrooms() {
        return this.numBathrooms;
    }

    public void setNumBathrooms(int numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public int getIsFurnished() {
        return this.isFurnished;
    }

    public boolean isFurnished() {
        if(isFurnished == 1)
            return true;
        else
            return false;
    }

    public void setIsFurnished(int isFurnished) {
        this.isFurnished = isFurnished;
    }

    //i don't know who made this but i'm afraid to change it
    //so our code is very weird with quadrant
    public Quadrant getQuadrant() {
        return this.quadrant;
    }

    public void setQuadrant(Quadrant quadrant) {
        this.quadrant = quadrant;
    }

    public int getRenterID() {
        return this.renterID;
    }

    public void setRenterID(int renterID) {
        this.renterID = renterID;
    }
}