package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementHeader;

import java.util.List;

/**
 * Created by DELL on 2016-11-30.
 */
public interface AdvertisementService {
    List<AdvertisementHeader> findAllAndSortOfLatest();
    List<AdvertisementHeader> findPageAndSortOfLatest(int nrPage);
    List<AdvertisementHeader> findAllByUsername(String username);
    AdvertisementDetails findOneByIdAdvertisement(Long idAdvertisement);


    void modifyAdvertisementWithAdvertisementDetails(AdvertisementDetails advertisementDetails);

    Advertisement saveAdvertisement(Advertisement newAdvertisement);

    List<AdvertisementHeader> advertisementConvertToAdvertisementHeader(List<Advertisement> advertisements);
    List<AdvertisementDetails> advertisementConvertToAdvertisementDetails(List<Advertisement> advertisements);


}
