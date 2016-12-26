package pl.wat.pz.application.web.rest.usr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value = "rest/usr/myOffer")
public class MyAdsRestController {

    @Autowired
    AdvertisementService advertisementService;

    /*
    @RequestMapping(value="/rest/duplicate", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)   //wyslane zadanie, nie oczekujemy odpowiedzi
    public void duplicate(Authentication auth){
        System.out.println("Jakies dzialanie, rowniez dla goscia");
    }
    */

    @RequestMapping(value="/getMyAll", method= RequestMethod.GET)
    public @ResponseBody List<AdvertisementHeader> getMyAll(Authentication auth) {
        String username = auth.getName();
        Locale locale = LocaleContextHolder.getLocale();
        return advertisementService.findAllByUsername(username,locale.getLanguage());
    }


}
