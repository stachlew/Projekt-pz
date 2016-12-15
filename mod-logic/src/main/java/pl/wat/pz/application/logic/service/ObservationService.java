package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;

import java.util.List;

/**
 * Created by Małgosia on 2016-12-08.
 */
public interface ObservationService {
    List<AdvertisementHeader> findByUsername(String username);
    void deleteObservation(Long idAdvertisement,String username);
    void saveObservation(String username, String adId);
}
