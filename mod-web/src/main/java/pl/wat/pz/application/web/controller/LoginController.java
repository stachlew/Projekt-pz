package pl.wat.pz.application.web.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(HttpServletResponse response) {
        return "login";
    }


    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "login";
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
            deleteCookiesFromList(request,response);
        }
        return "redirect:/#login";
    }

    private void deleteCookiesFromList(HttpServletRequest request, HttpServletResponse response) {
        List<String> deleteCookiesList = createCookieDeleteList();
        for (Cookie cookie : request.getCookies()) {
            if (deleteCookiesList.contains(cookie.getName())) {
                deleteCookie(cookie, request, response);
            }
        }
    }

    private List<String> createCookieDeleteList(){
        List<String> cookieDeleteList = new ArrayList<String>();
        cookieDeleteList.add("cookieUsername");
        return cookieDeleteList;
    }

    private void deleteCookie(Cookie cookie, HttpServletRequest request, HttpServletResponse response){
        cookie.setValue("");
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }

}
