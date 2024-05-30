package com.devleoh.glomo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("/test")
    public String test() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }

    @GetMapping("/test2")
    public String test2() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }

    @GetMapping("/test3")
    public String test3() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }
}
