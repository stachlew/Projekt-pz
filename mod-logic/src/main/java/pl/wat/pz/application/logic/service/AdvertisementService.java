package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementSearchForm;

import java.util.List;

/**
 * Created by DELL on 2016-11-30.
 */
public interface AdvertisementService {

    //--------FIND------------//

    List<AdvertisementHeader> findPageAndSortOfLatest(int nrPage,String lang);
    List<AdvertisementHeader> findAllByUsername(String username,String lang);
    AdvertisementDetails findOneByIdAdvertisement(Long idAdvertisement,String lang);

    byte[] findImageByIdAdvertisement(long idAdvertisement);


    //--------UPDATE--------//
    void modifyAdvertisementWithAdvertisementDetails(AdvertisementForm advertisementForm, Long idAdvertisement);

    //----------SAVE--------//
    long saveAdvertisement(Advertisement newAdvertisement);
    void saveImageToAdvertisement(long idAdvertisement,byte[] image);

    //------DELETE----------//
    void delete(Long idAdvertisement,String username);

    //--------Converts------------//
    List<AdvertisementHeader> advertisementConvertToAdvertisementHeader(List<Advertisement> advertisements,String lang);
    List<AdvertisementDetails> advertisementConvertToAdvertisementDetails(List<Advertisement> advertisements,String lang);
    Advertisement convertAdvertisementFormToAdvertisement(AdvertisementForm form, String username);

    List<AdvertisementHeader> findByFilter(AdvertisementSearchForm searchForm,String lang);

}
