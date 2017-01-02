package pl.wat.pz.application.web.rest.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementSearchForm;
import pl.wat.pz.application.logic.service.AdvertisementService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "rest/pub/search")
public class SearchRestController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value = "/doSearch",method = RequestMethod.POST)
    public @ResponseBody List<AdvertisementHeader>
    searchAds(@RequestBody AdvertisementSearchForm form, Locale locale){
        String lang = locale.getLanguage();

        /*
        System.out.println("Odebralem");
        System.out.println("title "+form.getTitle());
        System.out.println("category "+form.getCategory());
        System.out.println("region "+form.getRegion());
        System.out.println("city "+form.getCity());
        System.out.println("chargePerDayFrom "+form.getChargePerDayFrom());
        System.out.println("chargePerDayTo "+form.getChargePerDayTo());
        System.out.println("bailValueFrom "+form.getBailValueFrom());
        System.out.println("bailValueTo "+form.getBailValueTo());
        */

        return advertisementService.findByFilter(form,lang);
    }



}
