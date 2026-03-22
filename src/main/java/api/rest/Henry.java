package api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class Henry extends SpringBootServletInitializer {

    @GetMapping("/")
    public String home(){ return "Spring is here!";}

    @GetMapping("/hello")
    public String hello(){ return "Hello World!";}


    public static void main(String[] args) {
        SpringApplication.run(Henry.class, args);
    }

}