package ensf480.model;

//Fee class that represents the global fee paid to list a property
//singleton pattern
public class Fee {
    private float cost;
    private int durationDays;

    private static Fee instance; //singleton static instance

    //private constructor
    private Fee(float cost, int durationDays) {
        this.cost = cost;
        this.durationDays = durationDays;
    }

    //gets the current instance
    public static Fee getInstance() {
        if(instance == null) //makes new instance if none exists
            instance = new Fee(50, 60); //default values
        return instance;
    }

    //getters and setters
    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getDurationDays() {
        return this.durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }
}