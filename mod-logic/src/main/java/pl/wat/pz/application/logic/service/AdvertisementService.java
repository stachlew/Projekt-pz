package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.Advertisement;

import java.util.List;

/**
 * Created by DELL on 2016-11-30.
 */
public interface AdvertisementService {
    List<Advertisement> findAll();
    List<Advertisement> findAllAndSortOfLatest();
    List<Advertisement> findAllByUsername(String username);

    Advertisement saveAdvertisement(Advertisement newAdvertisement);
}
