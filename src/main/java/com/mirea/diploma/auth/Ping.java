package com.mirea.diploma.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Ping {
    @PostMapping("/ping")
    public String ping(@RequestParam String name) {
        System.out.println("PING IS HERE");
        return "Hello " + name;
    }
}
