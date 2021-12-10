package ensf480.model;

//Represents a property's address
//A simple container that stores the city quadrant and address
public class Address {
    private Quadrant quadrant;
    private String streetAddress;

    //constructor
    public Address(String streetAddress, String quadrant) {
        this.streetAddress = streetAddress;
        this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
    }

    //getters and setters
	public String getQuadrant() {
		return this.quadrant.toString();
	}

	public void setQuadrant(String quadrant) {
		this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
	}

    public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String street_address) {
		this.streetAddress = street_address;
	}

    //for email notification system
    @Override
    public String toString() {
        return "\nQuadrant: " + getQuadrant() + "\nAddresss: " + getStreetAddress();
    }

}

