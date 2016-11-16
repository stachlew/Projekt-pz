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
        // wersja pierwotna
        // model.addAttribute("wiadomosc", "Wiadomość przesłana Kamilzzak dzięki modelowi!");
        model.addAttribute("wiadomosc", "Hello frok work-branch again Wojtek!");
        userRepository.addUser(new User("aa","bb"));
        userRepository.downloadAllUsers();
        return "hello";
    }

    @RequestMapping("/guest")
    public String mainPageGuest(Model model) {
        //model.addAttribute("wiadomosc", "Wiadomość przesłana Kamilzzak dzięki modelowi!");
        return "homeGuest";
    }

    @RequestMapping("/user")
    public String mainPageUser(Model model) {
        //model.addAttribute("wiadomosc", "Wiadomość przesłana Kamilzzak dzięki modelowi!");
        return "homeUser";
    }

}