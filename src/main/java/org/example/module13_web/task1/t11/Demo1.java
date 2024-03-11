package org.example.module13_web.task1.t11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.module13_web.task1.Address;
import org.example.module13_web.task1.Company;
import org.example.module13_web.task1.GEO;
import org.example.module13_web.task1.User;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Demo1 {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        User user = User.builder()
                .name("Will")
                .username("Momo")
                .email("willmomo@gmail.com")
                .address(
                        Address.builder()
                                .city("Kyiv")
                                .street("some street")
                                .suite("my suite")
                                .zipcode("my zipcode")
                                .build()
                )
                .geo(
                        GEO.builder()
                                .lat(50.4545f)
                                .lng(-50.5656456f)
                                .build()
                )
                .phone("765-435")
                .website("some website")
                .company(
                        Company.builder()
                                .name("MyCompany")
                                .catchPhrase("Some catch phrase")
                                .bs("i dunno")
                                .build()
                )
                .build();

        HttpResponse<String> httpResponse = myPost(BASE_URL + "/users", user);

        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());

        // Повернуло id 11, на 1 більше ніж найбільший на сайті
        // Але об'єкт там не створюється, тому при виконанні завдань с оновленням і видаленням, повертає 404
        // Тому для цих завдань я використовував вже існуючі там юзери
        System.out.println("httpResponse.body() = " + httpResponse.body());



    }

    private static HttpResponse<String> myPost(String uri, User user) throws IOException, URISyntaxException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String userRequestJson = objectMapper.writeValueAsString(user);

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .POST(HttpRequest.BodyPublishers.ofString(userRequestJson))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
