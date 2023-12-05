package entity;

public class Location {
    private String locationName;
    private Integer temperature;
    private Integer humidity;
    private Double longitude;
    private Double latitude;
    private String nextLocationName;
    private Double[] nextCoordinates;

    public Location(String locationName, Double latitude, Double longitude, Integer temperature, Integer humidity, String nextLocationName, Double nextLocationLatitude, Double nextLocationLongitude) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.nextLocationName = nextLocationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nextCoordinates = new Double[]{nextLocationLatitude, nextLocationLongitude};
    }

    public String getName() {
        return locationName;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public int getModifiedTemperature(){
        if (temperature > 308) {
            return 3;
        } else if (temperature > 300){
            return 2;
        } else if (temperature > 290) {
            return 1;
        } else if (temperature > 283) {
            return  0;
        } else if (temperature > 275) {
            return -1;
        } else if (temperature > 264) {
            return -2;
        } else {
            return -3;
        }
    }

    public Integer getHumidity() {
        return humidity;
    }

    public int getModifiedHumidity() {
        if (humidity > 90) {
            return 2;
        } else if (humidity > 60) {
            return 1;
        } else if (humidity > 40) {
            return 0;
        } else if (humidity > 15) {
            return -1;
        } else {
            return -2;
        }
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public String getNextLocationName(){return this.nextLocationName;}

    public Double[] getNextCoordinates(){return this.nextCoordinates;}

    public String getLocationName() {
        return this.locationName;
    }

    public void setTemperature(int i) {
        this.temperature = i;
    }

}
