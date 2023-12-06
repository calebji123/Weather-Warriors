package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private int visibility;
    private int dt;
    private int timezone;
    private int id;
    private String name;
    private int cod;
    public static class Coord {
        private double lon;
        private double lat;
        public void setLon(double lon) {
            this.lon = lon;
        }
        public void setLat(double lat) {
            this.lat = lat;
        }
        public double getLon() {
            return lon;
        }
        public double getLat() {
            return lat;
        }
    }
    public static class Weather {
        private int id;
        private String main;
        private String description;
        private String icon;
        public void setId(int id) {
            this.id = id;
        }
        public void setMain(String main) {
            this.main = main;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }
        public int getId() {
            return id;
        }
        public String getMain() {
            return main;
        }
        public String getDescription() {
            return description;
        }
        public String getIcon() {
            return icon;
        }
    }
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;
        public void setTemp(double temp) {
            this.temp = temp;
        }
        public void setFeels_like(double feels_like) {
            this.feels_like = feels_like;
        }
        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }
        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }
        public void setPressure(int pressure) {
            this.pressure = pressure;
        }
        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
        public void setSea_level(int sea_level) {
            this.sea_level = sea_level;
        }
        public void setGrnd_level(int grnd_level) {
            this.grnd_level = grnd_level;
        }
        public double getTemp() {
            return temp;
        }
        public double getFeels_like() {
            return feels_like;
        }
        public double getTemp_min() {
            return temp_min;
        }
        public double getTemp_max() {
            return temp_max;
        }
        public int getPressure() {
            return pressure;
        }
        public int getHumidity() {
            return humidity;
        }
        public int getSea_level() {
            return sea_level;
        }
        public int getGrnd_level() {
            return grnd_level;
        }

    }
    public void setCoord(Coord coord) {
        this.coord = coord;
    }
    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
    public void setBase(String base) {
        this.base = base;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
    public void setDt(int dt) {
        this.dt = dt;
    }
    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public Main getMain() {
        return main;
    }
}
