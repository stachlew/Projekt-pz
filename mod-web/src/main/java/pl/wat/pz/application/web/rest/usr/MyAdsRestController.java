package pl.wat.pz.application.web.rest.usr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value = "rest/usr/myOffer")
public class MyAdsRestController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value="/getMyAll", method= RequestMethod.GET)
    public @ResponseBody List<AdvertisementHeader> getMyAll(Authentication auth) {
        String username = auth.getName();
        Locale locale = LocaleContextHolder.getLocale();
        return advertisementService.findAllByUsername(username,locale.getLanguage());
    }

    @RequestMapping(value = "/updateOffer/{idOffer}",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateOffer(@RequestBody AdvertisementForm advertisementForm, @PathVariable String idOffer, Authentication auth){
        if(auth!=null){
            String username = auth.getName();
            Locale locale = LocaleContextHolder.getLocale();
            try {
                Long offerIdLong = Long.parseLong(idOffer.trim());
                AdvertisementDetails adv = advertisementService.findOneByIdAdvertisement(offerIdLong,locale.getLanguage());
                if(adv.getUsername().equals(username)){
                    advertisementService.modifyAdvertisementWithAdvertisementDetails(advertisementForm,offerIdLong);
                }
            } catch (NumberFormatException nfe) {

            }
        }
    }


}
