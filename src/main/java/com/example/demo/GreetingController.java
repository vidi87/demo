package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private Environment env;

    private static final String template = "Hello, %s!";

    @GetMapping("/host")
    public String host() {
        return String.format(template, env.getProperty("HOSTNAME"));
    }

    @GetMapping("/pod")
    public String pod() {
        return String.format(template, env.getProperty("PODNAME"));
    }

    @GetMapping("/node")
    public String node() {
        return String.format(template, env.getProperty("NODENAME"));
    }

    @GetMapping("/status")
    public String status() {
        return "app is working";
    }
}
