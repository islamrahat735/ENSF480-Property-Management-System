package ensf480.model;

import java.util.ArrayList;

class Landlord extends Account {
    private static int nextID = 1;
    
    private ArrayList<Property> ownedProperties = new ArrayList<>();

    private int id;

    public Landlord(String username, String password, String fname, String lname){
        super(username, password, fname, lname);
        id = nextID;
        nextID++;
    }

    public ArrayList<Property> getOwnedProperties() {
		return this.ownedProperties;
	}

    public Property getProperty(int index) {
        return ownedProperties.get(index);
    }

    public Property addProperty(String type, Address address, int numBedrooms, int numBathrooms, boolean isFurnished, int ownerId){
        Property property = new Property(type, address, numBedrooms, numBathrooms, isFurnished, ownerId);
        ownedProperties.add(property);
        return property; //returns for convenience
    }

    public void removeProperty(Property property) {
        ownedProperties.remove(property);
    }

    public void editProperty(Property oldProperty, Property newProperty){
        int target = ownedProperties.indexOf(oldProperty);

        if(target != -1){
            ownedProperties.set(target, newProperty);
        } 
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
