package ar.com.educacionit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        //quiero ir a la página home.html ubicada en templates
        return "home";
    }
}
