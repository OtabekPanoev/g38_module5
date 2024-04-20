package uz.pdp.gson1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class GsonExample {

    @SuppressWarnings("unchecked")
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

        /*Gson gson = getGsonAdvanced();

        User user = new User(1, 10, "Adham", new Date(), LocalDate.now());

        String json = gson.toJson(user);
        System.out.println(json);// file writing

        User fromJson = gson.fromJson(json, TypeToken.get(User.class));
        System.out.println("fromJson = " + fromJson);*/


        Gson gson = getGsonAdvanced();

        String json = """
                [
                {
                    "name": "Mohamed",
                    "age": 53,
                    "id": 3
                }
                ]
                """;

        List<User> users = (List<User>) gson.fromJson(json, TypeToken.getParameterized(List.class, User.class));
        System.out.println(users);


    }

    private static Gson getGson() {
        return new Gson();
    }

    private static Gson getGsonAdvanced() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }
}
