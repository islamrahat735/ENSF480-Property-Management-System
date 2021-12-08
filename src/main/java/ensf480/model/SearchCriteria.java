package ensf480.model;

public class SearchCriteria {
    //private String city;
    
    //SearchCriteria stores a bunch of different attributes that are optional
    private PropertyType type;
    //private Address address;
    private int numBedrooms;
    private int numBathrooms;
    private boolean isFurnished;
    private Quadrant quadrant;
    //private String streetAddress;

    //city is mandatory criteria
    public SearchCriteria() {
    }

    //and a bunch of getters/setters
    public String getType() {
        return this.type.toString();
    }

    public void setType(String type) {
        this.type = PropertyType.valueOf(type.toUpperCase());
    }

    // public Address getAddress() {
    //     return this.address;
    // }

    // public void setAddress(Address address) {
    //     this.address = address;
    // }

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

    public String getQuadrant() {
        return this.quadrant.toString();
    }

    public void setQuadrant(String quadrant) {
        this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
    }

    // public String getStreetAddress() {
    //     return this.streetAddress;
    // }

    // public void setStreetAddress(String streetAddress) {
    //     this.streetAddress = streetAddress;
    // }


    public boolean getIsFurnished() {
        return this.isFurnished;
    }

    @Override
    public String toString() {
        return "{" +
            " type='" + getType() + "'" +
            ", numBedrooms='" + getNumBedrooms() + "'" +
            ", numBathrooms='" + getNumBathrooms() + "'" +
            ", isFurnished='" + isIsFurnished() + "'" +
            ", quadrant='" + getQuadrant() + "'" +
            "}";
    }



}