package ensf480.model;

public class SearchCriteria {
    //private String city;
    
    //SearchCriteria stores a bunch of different attributes that are optional
    private PropertyType type;
    private int numBedrooms;
    private int numBathrooms;
    private int isFurnished;

    private String streetAddress;
    private Quadrant quadrant;

    //starts with all criteria empty
    public SearchCriteria() {
        type = null;
        numBedrooms = -1;
        numBathrooms = -1;
        isFurnished = -1;
        streetAddress = null;
        quadrant = null;
    }

    //and a bunch of getters/setters
    public String getType() {
        return this.type.toString();
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

    public Quadrant getQuadrant() {
        return this.quadrant;
    }

    public void setQuadrant(Quadrant quadrant) {
        this.quadrant = quadrant;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}