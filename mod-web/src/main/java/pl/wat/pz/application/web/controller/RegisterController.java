package pl.wat.pz.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class RegisterController {

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegister(Model model)
    {
        //model.addAttribute("userSecurity",new UserSecurity());
        //model.addAttribute("userDetails", new UserAccountDetails());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegister()
    {
        return "register";
    }
}
