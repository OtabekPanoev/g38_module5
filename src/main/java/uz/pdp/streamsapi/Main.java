package uz.pdp.streamsapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String string = Files.readString(Path.of("students.json"));



        Gson gson = new Gson();
        gson.fromJson(string, )


    }
}
