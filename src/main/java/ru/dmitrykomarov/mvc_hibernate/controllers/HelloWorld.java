/*
 * @author Dmitry Komarov
 * Created 14.06.2024
 */


package ru.dmitrykomarov.mvc_hibernate.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user12212s")
public class HelloWorld {

    @GetMapping()
    public String helloWorld(){
        return "helloworld";
    }
}
