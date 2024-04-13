package uz.pdp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class HttpClientExample {
    public static void main(String[] args) throws Exception{

        HttpClient httpClient = HttpClient.newHttpClient();

//        getRequest1(httpClient);
//        getRequest2(httpClient);

        Gson gson = new Gson();
        System.out.println(gson.toJson(new Post("dhd", new Date().toString(), "1", "kda"), new TypeToken<Post>() {
        }.getType()));

//        HttpRequest build = HttpRequest.newBuilder()
//                .POST(HttpRequest.BodyPublishers.ofString())
//                .uri(URI.create("http://localhost:8080/posts/"))
//                .build();
//        HttpResponse<String> response = httpClient.send(build, HttpResponse.BodyHandlers.ofString());

    }

    private static void getRequest2(HttpClient httpClient) throws IOException, InterruptedException {
        HttpRequest build = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/posts/"))
                .build();
        HttpResponse<String> response = httpClient.send(build, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.uri() = " + response.uri());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());

        String body = response.body();
        // convert to json

        Gson gson = new Gson();
        Type type = new TypeToken<List<Post>>(){}.getType();
        List<Post> posts = gson.fromJson(body, type);

        Consumer<Post> consumer = System.out::println;
        posts.forEach(consumer);
    }

    private static void getRequest1(HttpClient httpClient) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/current-time")) // api
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.uri() = " + response.uri());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
    }
}
