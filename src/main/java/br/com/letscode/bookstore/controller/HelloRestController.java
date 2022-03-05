package br.com.letscode.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloRestController {

    @GetMapping(value = "/{name}")
    public String getHelloViaPathParam(@PathVariable("name") String name) {
        return hello(name) + ". Path Param";
    }

    @GetMapping
    public String getHelloViaQueryParam(@RequestParam("name") String name) {
        return hello(name) + ". Using Query Param";
    }

    private String hello(String name) {
        return "Hello " + name;
    }
}
