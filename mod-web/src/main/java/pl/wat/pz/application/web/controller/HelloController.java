package pl.wat.pz.application.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;


@Controller
public class HelloController {

    @RequestMapping("/")
    public String homePage( Model model, HttpServletResponse response,
                            @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername
                            )
    {
        model.addAttribute("username", cookieUsername);
        return "homePage";
    }

    @RequestMapping("/main")
    public String mainContent( Model model, HttpServletResponse response,
                            @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername
    )
    {
        model.addAttribute("username", cookieUsername);
        return "main";
    }

    @RequestMapping("/addItem")
    public String userAddItem( Model model, HttpServletResponse response,
                               @CookieValue(value = "cookieUsername", defaultValue = "Guest") String cookieUsername
    )
    {
        model.addAttribute("username", cookieUsername);
        return "addItem";
    }

    @RequestMapping("/register")
    public String register(Model model)
    {
        return "register";
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