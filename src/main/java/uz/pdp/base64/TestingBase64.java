package uz.pdp.base64;


import java.util.Base64;

public class TestingBase64 {
    public static void main(String[] args) {

//        simpleEncoding();
//        mimeEncoding();
//        urlEncoding();

//        Files.write(Path.of("1.mp3"), decoder.decode(data));


    }

    private static void urlEncoding() {
        Base64.Encoder encoder = Base64.getUrlEncoder();
        Base64.Decoder decoder = Base64.getUrlDecoder();

//   ?
        System.out.println(encoder.encodeToString("\"a?".getBytes()));
//        System.out.println(new String(decoder.decode("aGkgZzM4")));
//        ImE/fhfh
    }

    private static void mimeEncoding() {
        Base64.Encoder encoder = Base64.getMimeEncoder();
        Base64.Decoder decoder = Base64.getMimeDecoder();

        System.out.println(encoder.encodeToString("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda culpa cupiditate enim id laborum nam numquam odio placeat quam, qui quia, quidem sit temporibus voluptatem voluptates. Corporis ea earum exercitationem expedita in itaque non omnis perspiciatis, porro saepe, sit tenetur!".getBytes()));
        System.out.println(new String(decoder.decode("aGkgZzM4")));
    }

    private static void simpleEncoding() {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        System.out.println(encoder.encodeToString("hi g38".getBytes()));
        System.out.println(new String(decoder.decode("aGkgZzM4")));
    }
}
