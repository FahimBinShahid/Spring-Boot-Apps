package dev.shahid.first_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String ohio(){
        return "Welcome to Spring Framework";
    }
}
