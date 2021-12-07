package ensf480.model;



public class Address {
    //private String province;
    //private String city;
    private Quadrant quadrant;
    private String street_address; //includes apt #

    public Address(String street_address, String quadrant) {
        this.street_address = street_address;
        this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
    }

    //getters and setters
    /*
    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
    */

	public String getQuadrant() {
		return this.quadrant.toString();
	}

	public void setQuadrant(String quadrant) {
		this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
	}

    public String getStreet_address() {
		return this.street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}


    @Override
    public String toString() {
        return "{" +
            " quadrant='" + getQuadrant() + "'" +
            ", street_address='" + getStreet_address() + "'" +
            "}";
    }

}

enum Quadrant {
    NE,
    NW,
    SE,
    SW;

    public String toString() {
        switch(this) {
            case NE:
                return "NE";
            case NW:
                return "NW";
            case SE:
                return "SE";
            case SW:
                return "SW";
        }
        return null;
    }
}