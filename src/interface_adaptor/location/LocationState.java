package interface_adaptor.location;

public class LocationState {
    private String locationName;
    private Integer temperature;
    private Integer humidity;
    private String nextLocationName;

    public LocationState(LocationState copy) {
        locationName = copy.locationName;
        temperature = copy.temperature;
        humidity = copy.humidity;
        nextLocationName = copy.nextLocationName;
    }

    public LocationState() {}

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public String getNextLocationName() {
        return nextLocationName;
    }

    public void setNextLocationName(String nextLocationName) {
        this.nextLocationName = nextLocationName;
    }
}
