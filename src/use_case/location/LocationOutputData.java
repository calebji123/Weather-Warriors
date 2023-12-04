package use_case.location;

public class LocationOutputData {
    private String locationName;
    private Integer temperature;
    private Integer humidity;
    private String nextLocationName;
    private String log;

    public LocationOutputData(String locationName, Integer temperature, Integer humidity, String nextLocationName, String log) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.nextLocationName = nextLocationName;
        this.log = log;
    }

    public String getLocationName() {
        return locationName;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public String getNextLocationName() {
        return nextLocationName;
    }

    public String getLog() {
        return log;
    }
}
