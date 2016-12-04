package pl.wat.pz.application.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {

    @RequestMapping("/")
    public String homePage( Model model){
        return "homePage";
    }

    @RequestMapping("/errorPage")
    public String errorPage( Model model){
        return "errorPage";
    }

    @RequestMapping("/home")
    public String mainContent( Model model){
        return "home";
    }

    @RequestMapping("/addItem")
    public String userAddItem( Model model){
        return "addItem";
    }

    @RequestMapping("/register")
    public String register(Model model)
    {
        return "register";
    }

    @RequestMapping("/loaned")
    public String userLoaned(Model model){
        return "loaned";
    }

    @RequestMapping("/myAds")
    public String userMyAds(Model model){
        return "myAds";
    }

    @RequestMapping("/notifications")
    public String userNotifications(Model model){
        return "notifications";
    }

    @RequestMapping("/observed")
    public String userObserved(Model model)    {
        return "observed";
    }

    @RequestMapping("favicon.ico")
    public String favicon(){
        return "forward:/resources/image/icon/favicon.ico";
    }

}