package ensf480.model;

public class Manager extends Account {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manager(String username, String password, String fname, String lname){
        super(username, password, fname, lname);
    }

    public void editProperty(Property property){

    }

    public void setFeeRate(int cost, int durationDays){}

    // public Manager(String username, String password, String fname, String lname) {
    //     super(username, password, fname, lname);
    //     id = nextID;
    //     nextID++;
    // }
}
