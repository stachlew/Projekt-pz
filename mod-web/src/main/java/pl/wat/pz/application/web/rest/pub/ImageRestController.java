package pl.wat.pz.application.web.rest.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.wat.pz.application.logic.service.AdvertisementService;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class ImageRestController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value = "rest/pub/images/getImage/{offerId}",method = RequestMethod.GET)
    public void findImage(HttpServletResponse resp, @PathVariable String offerId){
        Path path = FileSystems.getDefault().getPath("","D:\\LocalRepoGit\\Projekt-pz\\mod-web\\src\\main\\resources\\stockFoto\\noFoto.jpg");

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
            System.out.println("IOException");
        }
        catch (NumberFormatException nfe){
            System.out.println("NumberFormatException");
        }
    }

    @RequestMapping(value = "rest/usr/images/uploadImage/{offerId}",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void uploadImage(@PathVariable String offerId, Authentication auth, @RequestParam("file") File file){
        //pobrac plik z uploadu
        /*
        System.out.println("Serwer upload");
        System.out.println("file: "+file.toString());
        System.out.println("file: "+file.getTotalSpace());
        //update na ogloszeniu

        try{
            Path path = FileSystems.getDefault().getPath("","D:\\LocalRepoGit\\Projekt-pz\\mod-web\\src\\main\\resources\\stockFoto\\ObrazDB3.jpg");
            byte[] dbImageByte = Files.readAllBytes(path);
            Blob dbImage = new javax.sql.rowset.serial.SerialBlob(dbImageByte);

            //newAd.setImage(dbImage);
        }
        catch (IOException ioe){
            System.out.println("IOException");
        }
        catch (SQLException sqle){
            System.out.println("SQLDataException");
        }
    }*/
}
