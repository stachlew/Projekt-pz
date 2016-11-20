package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String mainPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        String targetUrl = "";
        if(role.contains("ROLE_USER")) {
            model.addAttribute("username", auth.getName());
            targetUrl = "homeUser";
        }
        else {
            targetUrl = "homeGuest"; //ROLE_ANONYMOUS
        }
        return targetUrl;
    }

    @RequestMapping("/loaned")
    public String userLoaned(Model model) {
        return "loaned";
    }

    @RequestMapping("/myAds")
    public String userMyAds(Model model) {
        return "myAds";
    }

    @RequestMapping("/notifications")
    public String userNotifications(Model model) {
        return "notifications";
    }

    @RequestMapping("/observed")
    public String userObserved(Model model) {
        return "observed";
    }

}