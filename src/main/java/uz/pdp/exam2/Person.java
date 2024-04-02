package uz.pdp.exam2;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder // allArgs
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Person {
    private UUID id;
    private String username;
    private String name;
    private int age;
    private String password;
    private String phone;

//    public Person() {
//    }
}

class TestPerson {
    public static void main(String[] args) {
        Person person = Person.builder()
                .name("Ali")
                .age(10)
                .build();

        System.out.println(person);
    }
}