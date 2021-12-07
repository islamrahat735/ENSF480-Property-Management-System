package ensf480.model;


public class Property {
    //private static int idGenerator = 1;
    
    private int id = 0;



    private PropertyStatus status;
    private PropertyType type;
    private String address;
    private Quadrant quadrant;
 
    private int numBedrooms;
    private int numBathrooms;
    private boolean isFurnished;
    private String description;
    private int ownerId;
        
    public Property(String type, String address, String quadrant, int numBedrooms, int numBathrooms, boolean isFurnished, int ownerId) {
        //this.id = idGenerator;
        this.status = PropertyStatus.SUSPENDED;
        this.type = PropertyType.valueOf(type.toUpperCase());
        this.address = address;
        this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.isFurnished = isFurnished;
        this.ownerId = ownerId;

        //idGenerator++;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Quadrant getQuadrant() {
        return this.quadrant;
    }

    public void setQuadrant(Quadrant quadrant) {
        this.quadrant = quadrant;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", status='" + getStatus() + "'" +
            ", type='" + getType() + "'" +
            ", address='" + getAddress() + "'" +
            ", quadrant='" + getQuadrant() + "'" +
            ", numBedrooms='" + getNumBedrooms() + "'" +
            ", numBathrooms='" + getNumBathrooms() + "'" +
            ", isFurnished='" + isIsFurnished() + "'" +
            ", description='" + getDescription() + "'" +
            ", ownerId='" + getOwnerId() + "'" +
            "}";
    }


}
