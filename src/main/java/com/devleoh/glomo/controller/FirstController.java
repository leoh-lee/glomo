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

    @GetMapping("/test4")
    public String test4() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }

    @GetMapping("/test13")
    public String test5() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }

    @GetMapping("/test17")
    public String test7() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }

    @GetMapping("/test20")
    public String test20() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }

    @GetMapping("/test21")
    public String test21() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }

    @GetMapping("/test22")
    public String test22() {
        String a = "1";
        a += "2";
        a += "3";
        return a;
    }
}
