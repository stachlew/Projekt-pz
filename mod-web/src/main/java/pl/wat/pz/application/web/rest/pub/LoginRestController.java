package pl.wat.pz.application.web.rest.pub;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "rest/pub/login")
public class LoginRestController {

    @RequestMapping(value="/isLogged", method= RequestMethod.GET)
    public @ResponseBody boolean isLogged(Authentication auth){
        if(auth!=null)
            return true;
        else
            return false;
    }

}
