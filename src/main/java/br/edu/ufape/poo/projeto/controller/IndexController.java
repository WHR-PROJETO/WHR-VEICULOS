package br.edu.ufape.poo.projeto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/erro")
    public String index() {
        return "index";
    }
    
}
