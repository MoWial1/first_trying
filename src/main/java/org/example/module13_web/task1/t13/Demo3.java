package org.example.module13_web.task1.t13;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Demo3 {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        HttpClient httpClient = HttpClient.newHttpClient();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(BASE_URL + "/users/10"))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<Void> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.discarding());

        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());

        System.out.println("httpResponse.body() = " + httpResponse.body());
    }
}
