package uz.pdp.exam1;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User2 {
    private UUID id;
    private String username;
    private String name;
    private int age;
    private String password;
    private String phone;
}
