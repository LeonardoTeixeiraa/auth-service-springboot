package com.leonardoteixeira.cadastroDeUsuarios.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

public class CookieService {
    public static void setCookie(HttpServletResponse response, String key, String value, int seconds) {
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8));
        cookie.setPath("/");
        cookie.setMaxAge(seconds);
        response.addCookie(cookie);
    }


    public static String getCookie(HttpServletRequest request, String key) throws UnsupportedEncodingException{
        String valor = Optional.ofNullable(request.getCookies()).flatMap(cookies -> Arrays.stream(cookies)
                .filter(cookie -> key.equals(cookie.getName()))
                .findAny())
                .map(e -> e.getValue())
                .orElse(null);

        if (valor != null){
            return URLDecoder.decode(valor, StandardCharsets.UTF_8);

        }
        return valor;
    }
}
