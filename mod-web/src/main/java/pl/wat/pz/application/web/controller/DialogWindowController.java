package pl.wat.pz.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "dialogWindow/")
public class DialogWindowController {

    @RequestMapping(value = "/deleteObservedDialog",method = RequestMethod.GET)
    public String getDeleteObservedDialog(){
        return "dialogWindow/deleteObservedDialog";}
}
