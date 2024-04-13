package uz.pdp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class HttpClientExample {
    public static void main(String[] args) throws Exception{

        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpClient httpClient = HttpClient.newBuilder()
//                .authenticator(new Authenticator() {
//                    @Override
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication("user", "password1".toCharArray());
//                    }
//                })
//                .build();

//        getRequest1(httpClient);
//        getRequest2(httpClient);
//        post(httpClient);

        try {

            String url = String.format("http://localhost:8080/post/delete/%s", "b6554645-5cad-427f-bddd-c34e7190f569");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Basic " + Base64.getEncoder().encodeToString("user:password".getBytes()))
                    .DELETE()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response.uri() = " + response.uri());
            System.out.println("response.statusCode() = " + response.statusCode());
            System.out.println("response.body() = " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void post(HttpClient httpClient) throws IOException, InterruptedException {
        String body = """
                {
                    "title": "Xushhabar",
                    "body": "Lorem ipsum dolor sit amet, c"
                }
                """;
        Post post = new Post("Bla bla", null, null, "ghjsdbjsdnjfnrkjbrkwj");
        Gson gson = new Gson();
        String json = gson.toJson(post, TypeToken.get(Post.class).getType());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/post/create/"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.uri() = " + response.uri());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.body() = " + response.body());
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
