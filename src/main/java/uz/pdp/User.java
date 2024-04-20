package uz.pdp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private int age;
    private String name;
    private Date date;
    private LocalDateTime localDateTime;
}
