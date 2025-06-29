package com.LinguaNova.IdiomaGo.external.language;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.LinguaNova.IdiomaGo.util.AppRoutes.LANGUAGE_BASE_URL;

@Component
public class LanguageApiClient {

    private final RestTemplate restTemplate;

    public LanguageApiClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<Map<String, String>> fetchLanguagesFromExternalApi() {

        List<Map<String, Object>> response = restTemplate.getForObject(LANGUAGE_BASE_URL, List.class);

        return response.stream()
                .map(lang -> Map.of(
                        "code", lang.get("code").toString(),
                        "name", lang.get("name").toString()
                ))
                .collect(Collectors.toList());
    }
}
