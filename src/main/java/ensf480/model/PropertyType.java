package ensf480.model;

//enum that represents one of 6 different property types
public enum PropertyType {
    APARTMENT,
    ATTACHED_HOUSE,
    DETACHED_HOUSE,
    TOWNHOUSE,
    COMMERCIAL,
    OTHER;

    public String toString() {
        switch(this) {
            case APARTMENT:
                return "APARTMENT";
            case ATTACHED_HOUSE:
                return "ATTACHED_HOUSE";
            case DETACHED_HOUSE:
                return "DETACHED_HOUSE";
            case TOWNHOUSE:
                return "TOWNHOUSE";
            case COMMERCIAL:
                return "COMMERCIAL";
            case OTHER:
                return "OTHER";
        }
        return null;
    }
}

