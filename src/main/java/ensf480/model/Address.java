package ensf480.model;



public class Address {
    //private String province;
    //private String city;
    private Quadrant quadrant;
    private String streetAddress; //includes apt #

    public Address(String streetAddress, String quadrant) {
        this.streetAddress = streetAddress;
        this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
    }

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


    @Override
    public String toString() {
        return "{" +
            " quadrant='" + getQuadrant() + "'" +
            ", street_address='" + getStreetAddress() + "'" +
            "}";
    }

}

