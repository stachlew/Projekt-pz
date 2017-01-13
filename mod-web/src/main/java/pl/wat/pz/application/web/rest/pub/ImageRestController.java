package pl.wat.pz.application.web.rest.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.logic.service.AdvertisementService;
import pl.wat.pz.application.web.wrapper.BooleanResponse;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import org.apache.log4j.Logger;

@Controller
public class ImageRestController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value = "rest/pub/images/getImage/{offerId}",method = RequestMethod.GET)
    public void findImage(HttpServletResponse resp, @PathVariable String offerId){
        Path path = FileSystems.getDefault().getPath("","D:\\LocalRepoGit\\Projekt-pz\\mod-web\\src\\main\\resources\\stockFoto\\noFoto.jpg");
        Logger logger = Logger.getLogger(this.getClass().toString());

        try{
            byte [] dbImage = null;
            Long longOfferId = Long.parseLong(offerId);
            dbImage = advertisementService.findImageByIdAdvertisement(longOfferId);
            if(dbImage==null){ // brak obrazka = stockowy obrazek
                dbImage = Files.readAllBytes(path);
            }
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(dbImage);
        }
        catch (IOException ioe){
            logger.error("findImage() IOException "+offerId);
        }
        catch (NumberFormatException nfe){
            logger.error("findImage() NumberFormatException "+offerId);
        }
    }

    @RequestMapping(value = "rest/usr/images/deleteImage/{offerId}",method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable String offerId,Locale locale, Authentication auth){
        Long longOfferId = null;
        Logger logger = Logger.getLogger(this.getClass().toString());

        String lang = locale.getLanguage();
        try {
            longOfferId = Long.parseLong(offerId);
        }catch (NumberFormatException e){
            logger.error("deleteImage() NumberFormatException "+offerId);
        }
        AdvertisementDetails ad = advertisementService.findOneByIdAdvertisement(longOfferId,lang);
        if(ad!=null){
            if(ad.getUsername().equals(auth.getName())){
                advertisementService.saveImageToAdvertisement(longOfferId,null);
            }
        }
    }

    @RequestMapping(value = "rest/usr/images/uploadImage/{offerId}",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void uploadImage(@PathVariable String offerId,Locale locale, Authentication auth, @RequestParam("file") MultipartFile file) {
        String lang = locale.getLanguage();
        Logger logger = Logger.getLogger(this.getClass().toString());
        if(!file.isEmpty()){
            try{
                Long longOfferId = Long.parseLong(offerId);
                AdvertisementDetails ad = advertisementService.findOneByIdAdvertisement(longOfferId,lang);
                if(ad!=null){
                    if(ad.getUsername().equals(auth.getName())){
                        byte[] bytes = file.getBytes();
                        advertisementService.saveImageToAdvertisement(longOfferId,bytes);
                    }
                }
                /*
                //Zapis na lokalnym dla testu
                File serverFile = new File("D:\\LocalRepoGit\\Projekt-pz\\mod-web\\src\\main\\resources\\stockFoto"
                        + File.separator + offerId + ".jpg");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                */
            }catch (Exception e){
                logger.error("uploadImage() Exception "+offerId);
            }
        }
    }
}
