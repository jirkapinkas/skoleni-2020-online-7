package com.example.demoprimefaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // kdyz se prijde na http://localhost:8080, tak se provede redirect na /index.xhtml
    @GetMapping("/")
    public String home() {
        return "redirect:/index.xhtml";
    }

}
