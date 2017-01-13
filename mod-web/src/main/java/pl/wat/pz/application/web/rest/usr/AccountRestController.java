package pl.wat.pz.application.web.rest.usr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.wat.pz.application.dao.intermediateClass.User.UserForm;
import pl.wat.pz.application.logic.service.UserDetailsService;
import pl.wat.pz.application.web.validator.UserFormValidator;

@Controller
@RequestMapping(value = "rest/usr/account")
public class AccountRestController {


    @Autowired
    UserDetailsService userDetailsService;


    @RequestMapping(value = "/updateAccount",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateOffer(@RequestBody UserForm userForm, Authentication auth, BindingResult result){
        //UserForm USF = new UserForm("123","test@test.pl","919191919","Testowo","mazowieckie");
        UserFormValidator userFormValidator = new UserFormValidator();
        userFormValidator.validate(userForm, result);

        if(auth!=null && userForm!=null){
            if(result.hasErrors()) {
                System.out.println(result.getAllErrors());
            }
            else {
                String username = auth.getName();
                userDetailsService.modifyUserByUserForm(userForm,username);
            }
        }
    }
}
