package entity;

public class WeatherResponse {
    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private int dt;
    private Sys sys;
    private int timezone;
    private int id;
    private Rain rain;
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
    public static class Wind {
        private double speed;
        private int deg;
        private double gust;
        public void setSpeed(double speed) {
            this.speed = speed;
        }
        public void setDeg(int deg) {
            this.deg = deg;
        }
        public double getGust() {
            return gust;
        }
        public double getSpeed() {
            return speed;
        }
        public int getDeg() {
            return deg;
        }
        public void setGust(double gust) {
            this.gust = gust;
        }
    }
    public static class Clouds {
        private int all;
        public void setAll(int all) {
            this.all = all;
        }
        public int getAll() {
            return all;
        }
    }

    public static class Rain {
        private String duration;
        private Double depth;
        public void setDuration(String duration){
            this.duration = duration;
        }
        public void setDepth(Double depth){
            this.depth = depth;
        }
        public String getDuration(){
            return this.duration;
        }
        public Double getDepth(){
            return this.depth;
        }
    }

    public static class Sys {
        private int type;
        private int id;
        private String country;
        private int sunrise;
        private int sunset;
        public void setType(int type) {
            this.type = type;
        }
        public void setId(int id) {
            this.id = id;
        }
        public void setCountry(String country) {
            this.country = country;
        }
        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }
        public void setSunset(int sunset) {
            this.sunset = sunset;
        }
        public int getType() {
            return type;
        }
        public int getId() {
            return id;
        }
        public String getCountry() {
            return country;
        }
        public int getSunrise() {
            return sunrise;
        }
        public int getSunset() {
            return sunset;
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
    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }
    public void setDt(int dt) {
        this.dt = dt;
    }
    public void setSys(Sys sys) {
        this.sys = sys;
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
    public Coord getCoord() {
        return coord;
    }
    public Weather[] getWeather() {
        return weather;
    }
    public String getBase() {
        return base;
    }
    public Main getMain() {
        return main;
    }
    public int getVisibility() {
        return visibility;
    }
    public Wind getWind() {
        return wind;
    }
    public Clouds getClouds() {
        return clouds;
    }
    public int getDt() {
        return dt;
    }
    public Sys getSys() {
        return sys;
    }
    public int getTimezone() {
        return timezone;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCod() {
        return cod;
    }
}
