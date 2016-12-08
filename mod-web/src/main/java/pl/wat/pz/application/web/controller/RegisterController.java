package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pl.wat.pz.application.logic.intermediateClass.User.UserRegistered;

import pl.wat.pz.application.logic.service.UserDetailsService;




@Controller
public class RegisterController {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegister(){ return "register";}

    @RequestMapping(value="/register/createUser", method= RequestMethod.POST)
    public String createUser(@RequestBody UserRegistered userRegistered) {
        System.out.println("Przeslanie udane");
        userDetailsService.registerNewUserAccount(userRegistered);
        System.out.println("Dodano nowego usera: " + userRegistered.getUsername());
        return "login";
    }


}
