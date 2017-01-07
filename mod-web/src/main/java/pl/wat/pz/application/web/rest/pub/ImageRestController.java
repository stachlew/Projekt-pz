package pl.wat.pz.application.web.rest.pub;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@RequestMapping(value = "rest/pub/images")
public class ImageRestController {

    @RequestMapping(value = "/getImage/{offerId}",method = RequestMethod.GET)
    public void findImage(HttpServletResponse resp, @PathVariable String offerId){
        Path path = FileSystems.getDefault().getPath("","D:\\SEMV\\PZ_PROJEKT\\Projekt-pz\\mod-web\\src\\main\\resources\\stockFoto\\noFoto.jpg");

        try{
            byte [] dbImage = null;
            //serwis.pobierzObraz(offerId)
            if(dbImage==null){ // brak obrazka = stockowy obrazek
                dbImage = Files.readAllBytes(path);
            }
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(dbImage);
        }
        catch (IOException e){
            System.out.println("IOException");
        }
    }
}
