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
        Location location = dataAccessObject.getLocation();
        location.next();
        WeatherResponse response = WeatherAPI.getWeather(location.getLongitude(), location.getLatitude());
        LocationOutputData outputData = new LocationOutputData(location.getName(), response.getMain().getTemp(), response.getMain().getHumidity(), location.getNextLocation());
        presenter.prepareView(outputData);
    }
}