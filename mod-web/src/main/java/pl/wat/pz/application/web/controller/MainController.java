package pl.wat.pz.application.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;


@Controller
public class MainController {

    @RequestMapping("/")
    public String homePage(){
        return "homePage";
    }

    @RequestMapping("/errorPage")
    public String errorPage(){
        return "errorPage";
    }

    @RequestMapping("/home")
    public String mainContent(){
        return "home";
    }

    @RequestMapping("/offer")
    public String offer(){ return "offer";    }

    @RequestMapping("/editOffer")
    public String editOffer(){ return "editOffer";    }

    @RequestMapping("/loaned")
    public String userLoaned(){
        return "loaned";
    }

    @RequestMapping("/loanDetails")
    public String loanDetails(){ return "loanDetails"; }

    @RequestMapping("/myAds")
    public String userMyAds(){
        return "myAds";
    }

    @RequestMapping("/notifications")
    public String userNotifications(){
        return "notifications";
    }

    @RequestMapping("/observed")
    public String userObserved()    {
        return "observed";
    }

    @RequestMapping("favicon.ico")
    public String favicon(){
        return "forward:/resources/image/icon/favicon.ico";
    }

}