package ar.com.educacionit.controllers;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/socio")
public class SociosController {

    @Autowired
    private SociosService sociosService;

    @GetMapping("/all")
    public List<Socios> findAll() {
        return sociosService.findALL();
    }
}
