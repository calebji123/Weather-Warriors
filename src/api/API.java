import okhttp3.*;

import java.io.IOException;

public class API {
    public static String getWeather() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/weather?lat=43.6534817&lon=-79.3839347&appid=1fd90a6e1e3a573105fe5c0b472fa1a0")
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getWeather());
    }
}
