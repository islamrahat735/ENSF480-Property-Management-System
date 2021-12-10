package ensf480.model;

//represents a Property registered in our system
public class Property {
    private int id; //property id

    //attributes
    private PropertyStatus status;
    private PropertyType type;
    private Address address;
 
    private int numBedrooms;
    private int numBathrooms;
    private boolean isFurnished;
    private int ownerId;

    private String dateListed = null;
    private String dateRented = null;
        
    //constructor
    public Property(String type, Address address, int numBedrooms, int numBathrooms, boolean isFurnished, int ownerId) {
        this.status = PropertyStatus.SUSPENDED;
        this.type = PropertyType.valueOf(type.toUpperCase());
        this.address = address;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.isFurnished = isFurnished;
        this.ownerId = ownerId;
    }

    //checks each category and returns false if any of them mismatch
    public boolean matchesCriteria(SearchCriteria criteria) {
        //if it isn't null and the values aren't equal, the search doesn't match the criteria
        if(criteria.getType() != null && this.type != PropertyType.valueOf(criteria.getType()))
            return false;
        //we check each criteria individually
        if(criteria.getNumBedrooms() != -1 && this.numBedrooms != criteria.getNumBedrooms())
            return false;
        if(criteria.getNumBathrooms() != -1 && this.numBathrooms != criteria.getNumBathrooms())
            return false;
        if(criteria.getIsFurnished() != -1 && this.isFurnished != criteria.isFurnished())
            return false;
        if(criteria.getStreetAddress() != null && this.address.getStreetAddress() != criteria.getStreetAddress())
            return false;
        if(criteria.getQuadrant() != null && Quadrant.valueOf(this.address.getQuadrant()) != criteria.getQuadrant())
            return false;
        
        //all criteria passed, thus this property matches it
        return true;
    }

    //getters and setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status.toString();
    }

    public void setStatus(String status) {
        this.status = PropertyStatus.valueOf(status.toUpperCase());
    }

    public String getType() {
        return this.type.toString();
    }

    public void setType(String type) {
        this.type = PropertyType.valueOf(type.toUpperCase());
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

    public boolean isFurnished() {
        return this.isFurnished;
    }

    public void setIsFurnished(boolean isFurnished) {
        this.isFurnished = isFurnished;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getdateListed() {
        return dateListed;
    }

    public void setdateListed(String dateListed) {
        this.dateListed = dateListed;
    }

    public boolean isIsFurnished() {
        return this.isFurnished;
    }

    public boolean getIsFurnished() {
        return this.isFurnished;
    }

    public String getDateListed() {
        return this.dateListed;
    }

    public void setDateListed(String dateListed) {
        this.dateListed = dateListed;
    }

    public String getDateRented() {
        return this.dateRented;
    }

    public void setDateRented(String dateRented) {
        this.dateRented = dateRented;
    }

    //for debugging
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", status='" + getStatus() + "'" +
            ", type='" + getType() + "'" +
            address.toString() +
            ", numBedrooms='" + getNumBedrooms() + "'" +
            ", numBathrooms='" + getNumBathrooms() + "'" +
            ", isFurnished='" + isIsFurnished() + "'" +
            ", ownerId='" + getOwnerId() + "'" +
            ", dateListed='" + getDateListed() + "'" +
            ", dateRented='" + getDateRented() + "'" +
            "}\n";
    }


   
}
