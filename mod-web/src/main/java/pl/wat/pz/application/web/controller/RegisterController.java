package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import pl.wat.pz.application.logic.intermediateClass.User.UserRegistered;

import pl.wat.pz.application.logic.service.UserDetailsService;




@Controller
public class RegisterController {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegister(){ return "register";}

    @RequestMapping(value="/register/createUser", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void createUser(@RequestBody UserRegistered userRegistered) {
        userDetailsService.registerNewUserAccount(userRegistered);
    }


}
