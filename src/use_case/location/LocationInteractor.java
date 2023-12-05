package use_case.location;

import api.WeatherAPI;
import entity.Location;
import entity.WeatherResponse;

public class LocationInteractor implements LocationInputBoundary {
    final LocationDataAccessInterface dataAccessObject;
    final LocationOutputBoundary presenter;

    public LocationInteractor(LocationDataAccessInterface dataAccessObject, LocationOutputBoundary presenter) {
        this.dataAccessObject = dataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        String log = "";
        if (dataAccessObject.getTurn() % 3 == 0){
            dataAccessObject.nextLocation();
            log = "Location changed to " + dataAccessObject.getLocation().getLocationName() + "\r\n";
        }
        Location location = dataAccessObject.getLocation();
        LocationOutputData outputData = new LocationOutputData(location.getLocationName(), location.getTemperature(), location.getHumidity(), location.getNextLocationName(), log);
        presenter.prepareView(outputData);
    }
}
