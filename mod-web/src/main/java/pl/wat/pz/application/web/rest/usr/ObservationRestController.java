package pl.wat.pz.application.web.rest.usr;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.ObservationService;
import pl.wat.pz.application.web.wrapper.BooleanResponse;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "rest/usr/observation")
public class ObservationRestController {
    @Autowired
    ObservationService observationService;

    @RequestMapping(value="/getObserviation", method= RequestMethod.GET)
    public @ResponseBody
    List<AdvertisementHeader> getObservation(Authentication auth) {
        String username = auth.getName();
        Locale locale = LocaleContextHolder.getLocale();
        return observationService.findByUsername(username,locale.getLanguage());
    }

    @RequestMapping(value="/deleteObs/{idAdvertisement}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteObs(@PathVariable(value = "idAdvertisement") String idAdvertisement, Authentication auth) {
        String username = auth.getName();
        Long idAd = new Long(idAdvertisement);
        observationService.deleteObservation(idAd,username);
    }

    @RequestMapping(value="/createObs/{idAdvertisement}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void createObservation(@PathVariable(value = "idAdvertisement") String idAdvertisement, Authentication auth) {
        if(auth.isAuthenticated()) {
            String username = auth.getName();
            observationService.saveObservation(username, idAdvertisement);
        }
    }

    @RequestMapping(value="/checkObservation/{idAdvertisement}", method= RequestMethod.GET)
    public @ResponseBody
    BooleanResponse checkObservation(@PathVariable(value = "idAdvertisement") String idAdvertisement, Authentication auth) {
        BooleanResponse response = new BooleanResponse(false);
        if(auth.isAuthenticated()) {
            String username = auth.getName();
            boolean isObserved = false;
            isObserved = observationService.isObserved(username, idAdvertisement);
            if(isObserved) response.setFlag(true);
        }
        return response;
    }











}
