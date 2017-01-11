package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import pl.wat.pz.application.dao.intermediateClass.User.UserRegistered;

import pl.wat.pz.application.logic.service.UserDetailsService;
import pl.wat.pz.application.web.wrapper.BooleanResponse;
import pl.wat.pz.application.dao.domain.User;

@Controller
public class RegisterController {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegister(){ return "register";}

    @RequestMapping(value="/register/createUser", method= RequestMethod.POST)
    public @ResponseBody BooleanResponse createUser(@RequestBody UserRegistered userRegistered) {
        if(!userDetailsService.exist(userRegistered.getUsername())){
            User newUser = userDetailsService.registerNewUserAccount(userRegistered);
            if(newUser!=null)
                return new BooleanResponse(true);
        }
        return new BooleanResponse(false);
    }

}
