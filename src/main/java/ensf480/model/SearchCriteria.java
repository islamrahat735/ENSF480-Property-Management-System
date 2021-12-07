package ensf480.model;

public class SearchCriteria {
    //search is done by city
    private String city;
    
    //SearchCriteria stores a bunch of different attributes that are optional
    private PropertyType type;
    private Address address;
    private int numBedrooms;
    private int numBathrooms;
    private boolean isFurnished;
    private Quadrant quadrant;
    private String streetAddress;

    //city is mandatory criteria
    public SearchCriteria(String city) {
        this.city = city;
    }

    //and a bunch of getters/setters
    public String getType() {
        return this.type.toString();
    }

    public void setType(PropertyType type) {
        this.type = type;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public boolean isIsFurnished() {
        return this.isFurnished;
    }

    public void setIsFurnished(boolean isFurnished) {
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