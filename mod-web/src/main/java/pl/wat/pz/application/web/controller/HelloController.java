package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wat.pz.application.dao.domain.User;
import pl.wat.pz.application.dao.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class HelloController {
    @Autowired
    UserRepository userRepository;



    @RequestMapping("/")
    public String mainPage( Model model, HttpServletResponse response,
                            @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername
                            )
    {
        model.addAttribute("username", cookieUsername);
        return "homeTile";
    }

    @RequestMapping("/loaned")
    public String userLoaned(Model model,
           @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername)
    {
        model.addAttribute("username", cookieUsername);
        return "loaned";
    }

    @RequestMapping("/myAds")
    public String userMyAds(Model model,
           @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername)
    {
        model.addAttribute("username", cookieUsername);
        return "myAds";
    }

    @RequestMapping("/notifications")
    public String userNotifications(Model model,
           @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername)
    {
        model.addAttribute("username", cookieUsername);
        return "notifications";
    }

    @RequestMapping("/observed")
    public String userObserved(Model model,
           @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername)
    {
        model.addAttribute("username", cookieUsername);
        return "observed";
    }

}