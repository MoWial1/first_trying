package org.example.module13_web.task3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.module13_web.task1.User;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        // Пишемо id користувача, який нам потрібен
        int userId = 2;

        String uri = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";

        List<UserTodo> todos = getUserTodos(uri);

        todos.forEach(System.out::println);
    }

    private static List<UserTodo> getUserTodos(String uri) throws IOException, InterruptedException, URISyntaxException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("httpResponse.statusCode() = " + httpResponse.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List<UserTodo> list = objectMapper.readValue(httpResponse.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, UserTodo.class)
        );

        list = list.stream()
                .filter(x -> !x.isCompleted())
                .collect(Collectors.toList());

        return list;
    }
}
