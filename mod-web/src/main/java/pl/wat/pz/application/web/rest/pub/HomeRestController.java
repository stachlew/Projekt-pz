package pl.wat.pz.application.web.rest.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "rest/pub/home")
public class HomeRestController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value="/getLatest", method= RequestMethod.GET)
    public @ResponseBody List<AdvertisementHeader> getLatest() {
        Locale locale = LocaleContextHolder.getLocale();
        return advertisementService.findPageAndSortOfLatest(0,locale.getLanguage());
    }


}
