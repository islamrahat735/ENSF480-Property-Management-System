package ensf480.model;

public enum Quadrant {
    NE,
    NW,
    SE,
    SW;

    public String toString() {
        switch(this) {
            case NE:
                return "NE";
            case NW:
                return "NW";
            case SE:
                return "SE";
            case SW:
                return "SW";
        }
        return null;
    }
}
