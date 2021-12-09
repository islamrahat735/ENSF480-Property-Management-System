package ensf480.model;

public class Manager extends Account {

    int id;
    static int nextID = 1;

    public Manager(String username, String password, String fname, String lname) {
        super(username, password, fname, lname);
        id = nextID;
        nextID++;
    }
}
