package uz.pdp.gson2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private Detail detail;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Detail {
    private String name;
}


class Test {
    public static void main(String[] args) {

        Book book = new Book(1, new Detail("John"));

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String toJson = gson.toJson(book);
        System.out.println("toJson = \n" + toJson);

        Book book1 = gson.fromJson(toJson, TypeToken.get(Book.class));
        System.out.println("book1 = " + book1);
    }
}
