package com.LinguaNova.IdiomaGo.util;

public class AppRoutes {
    public static final String BACKEND_BASE_URL = "http://localhost:1731/idiomago";
    public static final String FRONTEND_BASE_URL = "http://localhost:5173";

    public static final String VERIFY_EMAIL_ENDPOINT = BACKEND_BASE_URL + "/auth/verify-email?token=";
    public static final String FRONTEND_REDIRECTION_URL = BACKEND_BASE_URL + "/oauth2/success?token=";

    public static final String IMAGES_BASE_URL = "https://api.unsplash.com/search/photos";
    public static final String LANGUAGE_BASE_URL = "https://libretranslate.com/languages";
    public static final String OPENAI_BASE_URL = "https://api.openai.com/v1/chat/completions";
}
