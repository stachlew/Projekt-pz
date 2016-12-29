package pl.wat.pz.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Marian on 2016-12-29.
 */
@Controller
public class AddLoanController {

    @RequestMapping("/addLoan")
    public String addLoan(){
        return "addLoan";
    }



}
