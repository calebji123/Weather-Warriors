package api;

import entity.WeatherResponse;
import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class WeatherAPI {


    public static WeatherResponse getWeather(double lat, double lon) {
        String API_KEY = System.getenv("WEATHER_API_KEY");
        if (API_KEY == null) {
            throw new RuntimeException("WEATHER_API_KEY environment variable not set");
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + API_KEY)
                .build();
        try {
            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse result = objectMapper.readValue(response.body().string(), WeatherResponse.class);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getWeather(-79.3817, 43.6459));
    }
}
