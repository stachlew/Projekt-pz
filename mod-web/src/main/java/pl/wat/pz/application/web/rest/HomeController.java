package pl.wat.pz.application.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value="/rest/getLatest", method= RequestMethod.GET)
    public @ResponseBody List<AdvertisementHeader> getAll() {
        return advertisementService.findPageAndSortOfLatest(1);
    }


}
