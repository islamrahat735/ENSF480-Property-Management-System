package ensf480.model;

public enum PropertyStatus {
    ACTIVE, //property listed, fee paid
    RENTED, //property sold
    CANCELLED, //property removed for other reason
    SUSPENDED; //fee not paid

    public String toString() {
        switch(this) {
            case ACTIVE:
                return "ACTIVE";
            case RENTED:
                return "RENTED";
            case CANCELLED:
                return "CANCELLED";
            case SUSPENDED:
                return "SUSPENDED";
        }
        return null;
    }
}
