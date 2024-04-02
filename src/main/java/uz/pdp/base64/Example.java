package uz.pdp.base64;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;

public class Example {
    public static void main(String[] args) throws IOException {

//        Base64.Encoder encoder = Base64.getEncoder();
//
//        byte[] bytes = Files.readAllBytes(Path.of("m1.png"));


        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            objects.add(i);
        }
        System.out.println(objects);
        Collections.shuffle(objects);
        System.out.println(objects);

    }
}
