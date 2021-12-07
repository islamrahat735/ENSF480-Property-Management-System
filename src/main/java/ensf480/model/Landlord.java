package ensf480.model;

import java.util.ArrayList;

class Landlord extends Account{
    private ArrayList<Property> ownedProperties;

	public Landlord(String username, String password ){
        super(username, password);
        this.ownedProperties = new ArrayList<>();
    }
    
    public ArrayList<Property> getOwnedProperties() {
		return this.ownedProperties;
	}

	public void setOwnedProperties(ArrayList<Property> ownedProperties) {
		this.ownedProperties = ownedProperties;
	}

    public Property registerProperty(String type, Address address, int numBedrooms, int numBathrooms, boolean isFurnished){
        Property property = new Property(type, address, numBedrooms, numBathrooms, isFurnished);
        ownedProperties.add(property);
        return property;
    }

    public void editOwnProperty(Property previousProperty, Property newProperty){
        
        int target = ownedProperties.indexOf(previousProperty);

        if(target != -1){
            ownedProperties.set(target, newProperty);
        } 

        
    }



}
