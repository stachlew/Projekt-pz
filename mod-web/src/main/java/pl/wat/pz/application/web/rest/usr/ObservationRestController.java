package pl.wat.pz.application.web.rest.usr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.ObservationService;

import java.util.List;

@Controller
@RequestMapping(value = "rest/usr/observation")
public class ObservationRestController {
    @Autowired
    ObservationService observationService;

    @RequestMapping(value="/getObserviation", method= RequestMethod.GET)
    public @ResponseBody
    List<AdvertisementHeader> getObservation(Authentication auth) {
        String username = auth.getName();
        return observationService.findByUsername(username);
    }

    @RequestMapping(value="/deleteObs/{idAdvertisement}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteObs(@PathVariable(value = "idAdvertisement") String idAdvertisement, Authentication auth) {
        String username = auth.getName();
        Long idAd = new Long(idAdvertisement);
        observationService.deleteObservation((long)idAd,username);
    }

    @RequestMapping(value="/createObs/{idAdvertisement}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void createObservation(@PathVariable(value = "idAdvertisement") String idAdvertisement, Authentication auth) {
        if(auth.isAuthenticated()) {
            String username = auth.getName();
            observationService.saveObservation(username, idAdvertisement);
        }
    }











}
