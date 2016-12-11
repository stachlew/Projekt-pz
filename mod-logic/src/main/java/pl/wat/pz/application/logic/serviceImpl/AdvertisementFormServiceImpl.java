package pl.wat.pz.application.logic.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.ItemCategory;
import pl.wat.pz.application.dao.domain.Region;
import pl.wat.pz.application.dao.domain.User;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.logic.service.AdvertisementFormService;
import pl.wat.pz.application.logic.service.ItemCategoryService;
import pl.wat.pz.application.logic.service.RegionService;
import pl.wat.pz.application.logic.service.UserDetailsService;

@Service
public class AdvertisementFormServiceImpl implements AdvertisementFormService{

    @Autowired
    RegionService regionService;

    @Autowired
    ItemCategoryService itemCategoryService;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public Advertisement convertAdvertisementFormToAdvertisement(AdvertisementForm form,String username, String lang){
        Advertisement advert = new Advertisement();
        advert.setTitle(form.getTitle());
        advert.setBailValue(form.getBailValue());
        advert.setChargePerDay(form.getChargePerDay());
        advert.setDescription(form.getDescription());
        advert.setCity(form.getCity());
        Region region = regionService.loadRegionByName(form.getRegion());
        advert.setIdRegion(region);
        ItemCategory category = itemCategoryService.findOneByCategoryName(form.getCategory(),lang);
        advert.setIdItemCategory(category);
        User user = userDetailsService.getUserByUsername(username);
        advert.setIdUser(user);
        return advert;
    }
}
