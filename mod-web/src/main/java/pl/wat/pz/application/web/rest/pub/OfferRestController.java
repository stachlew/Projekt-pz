package pl.wat.pz.application.web.rest.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.logic.service.AdvertisementService;


@Controller
@RequestMapping(value = "rest/pub/offer")
public class OfferRestController {

    @Autowired
    AdvertisementService advertisementService;

    @RequestMapping(value="/{offerId}", method= RequestMethod.GET)
    public @ResponseBody
    AdvertisementDetails getDetails(@PathVariable String offerId) {
        AdvertisementDetails advertisementDetails;
        try {
            long offerIdLong = Long.parseLong(offerId.trim());
            advertisementDetails=advertisementService.findOneByIdAdvertisement(offerIdLong);
        } catch (NumberFormatException nfe) {
            advertisementDetails=null;
        }
        return advertisementDetails;
    }
}
