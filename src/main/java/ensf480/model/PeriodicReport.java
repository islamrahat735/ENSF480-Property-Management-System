package ensf480.model;
import java.util.ArrayList;

public class PeriodicReport {
    private int numHousesListed;
    private int numHousesRented;
    private int numActiveListings;
    private ArrayList<Property> rentedHouses = new ArrayList<>();

    private static PeriodicReport instance;

    private PeriodicReport() {
        numHousesListed = 0;
        numHousesRented = 0;
        numActiveListings = 0;
        rentedHouses.clear();
    }

    public static PeriodicReport getInstance() {
        if(instance == null)
            instance = new PeriodicReport();
        return instance;
    }

    public PeriodicReport getPeriodicReport() {
        PeriodicReport report = instance;
        instance = new PeriodicReport(); //generates a new periodic report after
        return report;
    } 

    public int getNumHousesListed() {
        return this.numHousesListed;
    }

    public void setNumHousesListed(int numHousesListed) {
        this.numHousesListed = numHousesListed;
    }

    public int getNumHousesRented() {
        return this.numHousesRented;
    }

    public void setNumHousesRented(int numHousesRented) {
        this.numHousesRented = numHousesRented;
    }

    public int getNumActiveListings() {
        return this.numActiveListings;
    }

    public void setNumActiveListings(int numActiveListings) {
        this.numActiveListings = numActiveListings;
    }

    public ArrayList<Property> getRentedHouses() {
        return this.rentedHouses;
    }

    public void setRentedHouses(ArrayList<Property> rentedHouses) {
        this.rentedHouses = rentedHouses;
    }
}
