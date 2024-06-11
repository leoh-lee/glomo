package com.devleoh.glomo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping("test")
    public String test() {
        String a = "a";
        a += "b";
        a += "C";

        a = "a";
        a += "b";
        a += "C";

        return a;
    }

}
