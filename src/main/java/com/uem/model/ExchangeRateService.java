package com.uem.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExchangeRateService {

    private static final String API_URL =
            "https://api.frankfurter.dev/v1/latest?base=EUR&symbols=USD";
    private static final Pattern USD_PATTERN =
            Pattern.compile("\"USD\"\\s*:\\s*([0-9]+(?:\\.[0-9]+)?)");

    public double obtenerCambioEuroDolar() {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.err.println("Error HTTP " + response.statusCode() + ": " + response.body());
                return 1.0;
            }

            Matcher m = USD_PATTERN.matcher(response.body());
            if (m.find()) {
                return Double.parseDouble(m.group(1));
            }
            System.err.println("No se encontró USD en la respuesta: " + response.body());

        } catch (Exception e) {
            System.err.println("Error al conectar con la API: " + e.getMessage());
        }

        return 1.0;
    }
}