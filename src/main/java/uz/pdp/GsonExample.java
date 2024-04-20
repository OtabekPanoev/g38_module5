package uz.pdp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class GsonExample {
    public static void main(String[] args) throws IOException {

        /*tring json = Files.readString(Path.of("src/main/resources/users.json"));

        Gson gson = new Gson();
        // from json to pojo
        // from pojo to json

        TypeToken<List<User>> typeToken = new TypeToken<>() {
        };

        List<User> users = gson.fromJson(json, typeToken);
        users.forEach(System.out::println);*/

        /*String str = """
                [
                {
                    "name": "Mohamed",
                    "age": 53,
                    "id": 3
                }
                ]
                """;

        User user = gson.fromJson(str, User.class);
        System.out.println(user);*/

        User user = new User(1, 10, "Adham", new Date(), LocalDateTime.now());
        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);


    }
}
