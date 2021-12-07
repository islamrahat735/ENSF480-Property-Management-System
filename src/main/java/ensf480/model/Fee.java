package ensf480.model;

//singleton
public class Fee {
    private float cost;
    private int durationDays;

    private static Fee instance;

    private Fee(float cost, int durationDays) {
        this.cost = cost;
        this.durationDays = durationDays;
    }

    public static Fee getInstance() {
        if(instance == null)
            instance = new Fee(50, 60);
        return instance;
    }

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