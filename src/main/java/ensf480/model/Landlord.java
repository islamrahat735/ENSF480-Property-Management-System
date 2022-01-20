package ensf480.model;

import java.util.ArrayList;

//Landlord that represents a Landlord user account
public class Landlord extends Account {
    private int lid; //landlord ID

    //constructor
    public Landlord(String username, String password, String fname, String lname){
        super(username, password, fname, lname);
    }

    //getters/setters
    public int getId() {
        return this.lid;
    }

    public void setId(int id) {
        this.lid = id;
    }


    @Override
    public String toString() {
        return "{" +
            " lid='" + getId() + "'" +
            "}";
    }

}
