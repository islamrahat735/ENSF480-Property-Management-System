package ensf480.model;

//ListingObserver interface used for RegisteredLandlord pseudo-observer pattern
public interface ListingObserver {
    public Email update(Property property);
}
