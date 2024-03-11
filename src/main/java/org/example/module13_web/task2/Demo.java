package org.example.module13_web.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        // Пишемо id користувача, який нам потрібен
        int userId = 2;
        int postId = getLatestPostId(userId);


        String uri = BASE_URL + "/posts/" + postId + "/comments";

        String filePath =  "src\\main\\java\\org\\example\\module13_web\\task2\\"
                + "user-" + userId + "-post-" + postId + "-comments.json";

        String commentsData = getComments(uri);

        System.out.println("commentsData = " + commentsData);
        writeToFile(filePath, commentsData);

        System.out.println("Comments data written to file: " + filePath);
    }

    private static int getLatestPostId(int userId) throws IOException, InterruptedException, URISyntaxException {
        String uri = BASE_URL + "/users/" + userId + "/posts";

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("{44 line} httpResponse.statusCode() = " + httpResponse.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List<UserComments> userCommentsList = Arrays.asList(objectMapper.readValue(httpResponse.body(), UserComments[].class));

        int maxId = userCommentsList.stream()
                .mapToInt(UserComments::getId)
                .max()
                .orElse(0);

        return maxId;
    }

    private static String getComments(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println("{72 line} httpResponse.statusCode() = " + httpResponse.statusCode());

        return httpResponse.body();
    }

    private static void writeToFile(String fileName, String data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(data);

        objectMapper.writeValue(new File(fileName), jsonString);
    }
}
