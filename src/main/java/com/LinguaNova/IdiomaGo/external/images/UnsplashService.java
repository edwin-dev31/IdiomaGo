package com.LinguaNova.IdiomaGo.external.images;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;

@Component
public class UnsplashService {

    private static String accessKey;

    public UnsplashService(@Value("${unsplash.access.key}") String key) {
        UnsplashService.accessKey = key;
    }

    private static final String BASE_URL = "https://api.unsplash.com/search/photos";

    public static String getImageUrlForWord(String word) {
        RestTemplate restTemplate = new RestTemplate();
        Random random = new Random();

        int perPage = random.nextInt(50) + 1;
        String url = BASE_URL + "?query=" + word + "&client_id=" + accessKey + "&per_page=" + perPage;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return extractRandomImageUrl(response.getBody());
            }

            url = BASE_URL + "?query=" + word + "&client_id=" + accessKey + "&per_page=1";
            response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return extractRandomImageUrl(response.getBody());
            }

        } catch (Exception e) {
            System.out.println("❌ Error to get Image using Unsplash: " + e.getMessage());
        }

        return null;
    }

    private static String extractRandomImageUrl(String jsonBody) {
        try {
            JSONObject json = new JSONObject(jsonBody);

            if (!json.has("results")) return null;

            JSONArray results = json.getJSONArray("results");

            if (results.length() == 0) return null;

            int index = new Random().nextInt(results.length());
            JSONObject image = results.getJSONObject(index);

            if (image.has("urls") && image.getJSONObject("urls").has("regular")) {
                return image.getJSONObject("urls").getString("regular");
            }

        } catch (Exception e) {
            System.out.println("❌ Error to process JSON: " + e.getMessage());
        }

        return null;
    }
}
