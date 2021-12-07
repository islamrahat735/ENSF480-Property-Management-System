package ensf480.model;



public class Address {
    private String province; //assuming all properties are within Canada
    private String city;
    private Quadrant quadrant;
    private String street_address; //includes apt #

    public Address(String province, String city, String quadrant, String street_address) {
        this.province = province.toLowerCase();
        this.city = city.toLowerCase();
        if(!quadrant.isEmpty()) {
            this.quadrant = Quadrant.valueOf(quadrant.toUpperCase());
        }
        this.street_address = street_address;
    }

    //getters and setters
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

	public Quadrant getQuadrant() {
		return this.quadrant;
	}

	public void setQuadrant(Quadrant quadrant) {
		this.quadrant = quadrant;
	}

    public String getStreet_address() {
		return this.street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
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