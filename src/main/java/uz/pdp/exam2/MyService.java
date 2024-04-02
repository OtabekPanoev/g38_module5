package uz.pdp.exam2;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@AllArgsConstructor
public class MyService {
    private final String userService;
    private final String adminService;
}

class TestMyService {
    public static void main(String[] args) {
        MyService myService = new MyService("", "");
    }
}
