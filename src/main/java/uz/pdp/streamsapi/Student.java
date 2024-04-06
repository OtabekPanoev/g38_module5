package uz.pdp.streamsapi;

import lombok.Data;
import lombok.ToString;

@Data
public class Student {
    private long id;
    private String full_name; // snake_case // camelCase
    private String country;
    private String gender;
    private int age; // 4 byte

}
