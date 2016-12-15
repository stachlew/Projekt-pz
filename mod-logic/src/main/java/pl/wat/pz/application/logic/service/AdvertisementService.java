package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;

import java.util.List;

/**
 * Created by DELL on 2016-11-30.
 */
public interface AdvertisementService {

    //--------FIND------------//
    List<AdvertisementHeader> findAllAndSortOfLatest();
    List<AdvertisementHeader> findPageAndSortOfLatest(int nrPage);
    List<AdvertisementHeader> findAllByUsername(String username);
    AdvertisementDetails findOneByIdAdvertisement(Long idAdvertisement);


    //--------UPDATE--------//
    void modifyAdvertisementWithAdvertisementDetails(AdvertisementDetails advertisementDetails);

    //----------SAVE--------//
    Advertisement saveAdvertisement(Advertisement newAdvertisement);

    //------DELETE----------//
    void delete(Long idAdvertisement);

    //--------Converts------------//
    List<AdvertisementHeader> advertisementConvertToAdvertisementHeader(List<Advertisement> advertisements);
    List<AdvertisementDetails> advertisementConvertToAdvertisementDetails(List<Advertisement> advertisements);
    Advertisement convertAdvertisementFormToAdvertisement(AdvertisementForm form, String username);

}
