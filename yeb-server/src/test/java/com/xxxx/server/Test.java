package com.xxxx.server;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePass = passwordEncoder.encode("123");
        System.out.println(encodePass);
        boolean matches = passwordEncoder.matches("123", encodePass);
        System.out.println(matches);
    }
}
