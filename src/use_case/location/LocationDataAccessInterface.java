package use_case.location;

import entity.Location;

public interface LocationDataAccessInterface {

    Location getLocation();
    void nextLocation();
    Integer getTurn();
}
