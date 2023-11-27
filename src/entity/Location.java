package entity;

public class Location {
    private String locationName;
    private Integer temperature;
    private Integer humidity;
    private Double longitude;
    private Double latitude;
    private String nextLocationName;

    public Location(String locationName, Double latitude, Double longitude, Integer temperature, Integer humidity, String nextLocationName) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.nextLocationName = nextLocationName;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getNextLocationName(){return this.nextLocationName;}

}
