package ensf480.model;

import java.util.ArrayList;

class Landlord{
    //private static int idGenerator = 0;
    
    private ArrayList<Property> ownedProperties;
    private Account account;

    private int id = 0;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Landlord(String username, String password ){
        this.account = new Account(username, password);
        this.ownedProperties = new ArrayList<>();
    }
    
    public ArrayList<Property> getOwnedProperties() {
		return this.ownedProperties;
	}

	public void setOwnedProperties(ArrayList<Property> ownedProperties) {
		this.ownedProperties = ownedProperties;
	}

    public Property registerProperty(String type, String address, String quadrant, int numBedrooms, int numBathrooms, boolean isFurnished, int ownerId){
        Property property = new Property(type, address, quadrant, numBedrooms, numBathrooms, isFurnished, ownerId);
        ownedProperties.add(property);
        return property;
    }

    public void editOwnProperty(Property previousProperty, Property newProperty){
        
        int target = ownedProperties.indexOf(previousProperty);

        if(target != -1){
            ownedProperties.set(target, newProperty);
        } 

        
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }




}
