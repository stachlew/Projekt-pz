package pl.wat.pz.application.web.rest.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementSearchForm;
import pl.wat.pz.application.logic.service.AdvertisementService;
import pl.wat.pz.application.web.validator.AdvertisementSearchFormValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "rest/pub/search")
public class SearchRestController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value = "/doSearch",method = RequestMethod.POST)
    public @ResponseBody List<AdvertisementHeader>
    searchAds(@RequestBody AdvertisementSearchForm form, Locale locale, BindingResult result){
        String lang = locale.getLanguage();
        AdvertisementSearchFormValidator advertisementSearchFormValidator = new AdvertisementSearchFormValidator();
        advertisementSearchFormValidator.validate(form, result);


        if(!result.hasErrors()) {
            return advertisementService.findByFilter(form,lang);
        }
        else{
            List<AdvertisementHeader> list = new ArrayList<>();
            return list;
        }
    }



}
