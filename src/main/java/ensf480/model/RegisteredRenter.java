package ensf480.model;

//Registered Renter account
public class RegisteredRenter extends Account {

    private int rid; //Renter ID

    public RegisteredRenter(String username, String password, String fname, String lname) {
        super(username, password, fname, lname);
    }

    public int getId() {
        return this.rid;
    }

    public void setID(int id) {
        this.rid = id;
    }
}