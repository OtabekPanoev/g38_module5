package uz.pdp.exam1;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String name;
    private int age;
    private String password;
    private String phone;

    public User() {
    }

    public User(UUID id, String username, String name, int age, String password, String phone) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.password = password;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, age, password, phone);
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", password='" + password + '\'' +
//                ", phone='" + phone + '\'' +
//                '}';
//    }
}
