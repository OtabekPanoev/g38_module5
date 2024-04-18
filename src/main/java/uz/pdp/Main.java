package uz.pdp;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Main {
    private static String booksListAsStringJSON;

//    static {
//        try {
//            String file = Main.class.getClassLoader().getResource("Books.json").getFile();
//            booksListAsStringJSON = Files.readString(Path.of(file));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Hello PDP!");
//         defaultConfiguration();
        Gson gson = new GsonBuilder()
                //.registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                //.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .serializeNulls()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                // .excludeFieldsWithoutExposeAnnotation()
                // .excludeFieldsWithModifiers(Modifier.VOLATILE, Modifier.PROTECTED)
                .setVersion(1.2)
                .create();

        Stream.generate(UUID::randomUUID).limit(50).forEach(System.out::println);


        Book book = Book.builder()
                .bookId(1)
                .bookTitle("Reactive Spring")
                .bookAuthor("Josh Long")
                .publishedDate(LocalDate.of(2021, 1, 1))
                .build();

        String jsonDATA = gson.toJson(book);
        System.out.println(jsonDATA);
        Book fromJson = gson.fromJson(jsonDATA, Book.class);
        System.out.println(fromJson);

    }

    private static void cuntomConfiguration(Gson gson) {
        Type type = new TypeToken<List<Book>>() {
        }.getType();
        List<Book> books = gson.fromJson(booksListAsStringJSON, type);
        books.forEach(System.err :: println);
    }

    private static void defaultConfiguration() {
        Gson gson = new Gson();
        Book book = Book.builder()
                .bookId(1)
                .bookTitle("Reactive Spring")
                .bookAuthor("Josh Long")
                .bookDate(new Date())
//                .publishedDate(LocalDate.of(2021, 1, 1))
                .build();
        String jsonDATA = gson.toJson(book);
        System.out.println(jsonDATA);
        // System.out.println(booksListAsStringJSON);
//        Type type = new TypeToken<List<Book>>() {
//        }.getType();
//        List<Book> books = gson.fromJson(booksListAsStringJSON, type);
//        books.forEach(System.err :: println);
    }
}