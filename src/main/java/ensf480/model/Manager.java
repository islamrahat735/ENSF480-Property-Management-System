package ensf480.model;

//Manager class that represents a manager account
public class Manager extends Account {

    private int mid; //manager ID

    //constructor
    public Manager(String username, String password, String fname, String lname){
        super(username, password, fname, lname);
    }

    public int getId() {
        return this.mid;
    }

    public void setId(int id) {
        this.mid = id;
    }

    //for testing
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "', " + super.toString() +
            "}";
    }

}
