package interface_adaptor.location;

import use_case.location.LocationInputBoundary;

public class LocationController {
    final LocationInputBoundary locationInputBoundary;

    public LocationController(LocationInputBoundary locationInputBoundary) {
        this.locationInputBoundary = locationInputBoundary;
    }

    public void execute() {
        locationInputBoundary.execute();
    }
}
