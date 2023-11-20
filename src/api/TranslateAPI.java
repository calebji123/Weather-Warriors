package api;

import okhttp3.OkHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TranslateAPI {
    public static class TranslationResponse {
        private Translation[] translations;

        public Translation[] getTranslations() {
            return translations;
        }

        public void setTranslations(Translation[] translations) {
            this.translations = translations;
        }

        public static class Translation {
            private String detected_source_language;
            private String text;

            public String getDetected_source_language() {
                return detected_source_language;
            }

            public void setDetected_source_language(String detected_source_language) {
                this.detected_source_language = detected_source_language;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
    }
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
            return result.translations[0].getText();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
