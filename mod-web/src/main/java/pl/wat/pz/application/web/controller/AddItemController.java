package pl.wat.pz.application.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.logic.service.AdvertisementService;
import pl.wat.pz.application.web.validator.AdvertisementFormValidator;
import pl.wat.pz.application.web.wrapper.StringResponse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import org.apache.log4j.Logger;

@Controller

public class AddItemController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping("/addItem")
    public String userAddItem(){
        return "addItem";
    }

    @RequestMapping(value = "/addItem/createItem", method= RequestMethod.POST)
    public @ResponseBody
    StringResponse createItem(@RequestBody AdvertisementForm advertisementForm, Authentication auth, BindingResult result){
        Logger logger = Logger.getLogger(this.getClass().toString());

        if(auth!=null){
            AdvertisementFormValidator advertisementFormValidator = new AdvertisementFormValidator();
            advertisementFormValidator.validate(advertisementForm, result);
            if(result.hasErrors()) {
                logger.error("createItem() result.hasErrors() "+ result.getAllErrors());
            }
            else {
                Locale locale = LocaleContextHolder.getLocale();
                Timestamp addDate = new Timestamp(Calendar.getInstance().getTime().getTime());
                Advertisement newAd = advertisementService.convertAdvertisementFormToAdvertisement(advertisementForm,auth.getName());
                newAd.setDateAdded(addDate);
                Long idAdvertisement = advertisementService.saveAdvertisement(newAd);
                if(idAdvertisement!=null){
                    return new StringResponse(idAdvertisement.toString());
                }
            }
        }
        return null;
    }

}
