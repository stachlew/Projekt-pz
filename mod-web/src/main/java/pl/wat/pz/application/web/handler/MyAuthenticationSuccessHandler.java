package pl.wat.pz.application.web.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.log4j.Logger;

@Component
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Logger logger = Logger.getLogger(this.getClass().toString());
        String username = authentication.getName();
        response.addCookie(new Cookie("cookieUsername", username));
        logger.info("onAuthenticationSuccess() LOG-IN: "+ username);
        //setDefaultTargetUrl("/home");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}