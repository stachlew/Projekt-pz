package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wat.pz.application.dao.domain.User;
import pl.wat.pz.application.dao.repository.UserRepository;


@Controller
public class HelloController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String dowolneWitaj(Model model) {
        model.addAttribute("wiadomosc", "Wiadomość przesłana Kamilzzak dzięki modelowi!");

        userRepository.addUser(new User("aa","bb"));
        userRepository.downloadAllUsers();
        return "hello";
    }

}