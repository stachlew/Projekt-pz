package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementHeader;

import java.util.List;

/**
 * Created by DELL on 2016-11-30.
 */
public interface AdvertisementService {
    List<AdvertisementHeader> findAllAndSortOfLatestAndConvertToAdvertisementHeader();
    List<AdvertisementHeader> findTopTenOfLatestAndConvertToAdvertisementHeader();
    List<AdvertisementHeader> findAllByUsernameAndConvertToAdvertisementHeader(String username);
    AdvertisementDetails findOneByIdAdvertisementAndConvertToAdvertisementDetails(Long idAdvertisement);


    void modifyAdvertisementWithAdvertisementDetails(AdvertisementDetails advertisementDetails);

    Advertisement saveAdvertisement(Advertisement newAdvertisement);


}
