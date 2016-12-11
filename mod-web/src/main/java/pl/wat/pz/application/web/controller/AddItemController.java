package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.logic.service.AdvertisementFormService;
import pl.wat.pz.application.logic.service.AdvertisementService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;

/*
    Przy zapisywaniu wyrzuca błąd braku integralności w bazie na koluminie id ogłoszenia
*/

@Controller

public class AddItemController {

    @Autowired
    AdvertisementService advertisementService;

    @Autowired
    AdvertisementFormService advertisementFormService;

    @RequestMapping("/addItem")
    public String userAddItem(){
        return "addItem";
    }

    @RequestMapping(value = "/addItem/createItem", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void createItem(@RequestBody AdvertisementForm advertisementForm, Authentication auth){

        if(auth!=null){
            Locale locale = LocaleContextHolder.getLocale();
            Timestamp addDate = new Timestamp(Calendar.getInstance().getTime().getTime());
            Advertisement newAd = advertisementFormService.convertAdvertisementFormToAdvertisement(advertisementForm,auth.getName(),locale.getLanguage());
            newAd.setDateAdded(addDate);
//            System.out.println("newAd title: "+newAd.getTitle());
//            System.out.println("newAd bail: "+newAd.getBailValue());
//            System.out.println("newAd charge: "+newAd.getChargePerDay());
//            System.out.println("newAd description: "+newAd.getDescription());
//            System.out.println("newAd city: "+newAd.getCity());
//            System.out.println("newAd region: "+newAd.getIdRegion().getName());
//            System.out.println("newAd category: "+newAd.getIdItemCategory().getNameENG());
//            System.out.println("newAd id: "+newAd.getIdAdvertisement());
//            System.out.println("newAd date: "+newAd.getDateAdded());
//            System.out.println("newAd user: "+newAd.getIdUser().getUsername());
            advertisementService.saveAdvertisement(newAd);
        }
    }

}
