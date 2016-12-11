package pl.wat.pz.application.logic.service;


import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementForm;

public interface AdvertisementFormService {
    Advertisement convertAdvertisementFormToAdvertisement(AdvertisementForm form, String username, String lang);
}
