package api;

import entity.TranslationResponse;
import okhttp3.OkHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TranslateAPI {

    public static String translate(String lang, String message) {
        String API_KEY = System.getenv("DEEPL_API_KEY");
        if (API_KEY == null) {
            throw new RuntimeException("DEEPL_API_KEY environment variable not set");
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("https://api-free.deepl.com/v2/translate")
                .post(new okhttp3.FormBody.Builder()
                        .add("auth_key", API_KEY)
                        .add("text", message)
                        .add("target_lang", lang)
                        .build())
                .build();
        try {
            okhttp3.Response response = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            TranslationResponse result = objectMapper.readValue(response.body().string(), TranslationResponse.class);
            return result.getTranslations()[0].getText();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
