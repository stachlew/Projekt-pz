package pl.wat.pz.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String dowolneWitaj(Model model) {
        model.addAttribute("wiadomosc", "Wiadomość przesłana Kamilk dzięki modelowi!");
        return "hello";
    }

}