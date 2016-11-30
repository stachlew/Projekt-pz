package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.repository.AdvertisementRepository;
import pl.wat.pz.application.logic.intermediateClass.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by DELL on 2016-11-30.
 */
@Service("AdvertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;


    @Override
    public List<Advertisement> findAll() {
        List<Advertisement> advertisementList = advertisementRepository.findAll();
        return advertisementList;
    }

    @Override
    public List<AdvertisementHeader> findAllAndSortOfLatestAndConvertToAdvertisementHeader() {
        List<Advertisement> advertisementListSorted = advertisementRepository.findAll(new Sort(Sort.Direction.DESC, "dateAdded"));
        List<AdvertisementHeader> advertisementHeaders = new LinkedList<>();
        for (Advertisement adv:advertisementListSorted) {
            advertisementHeaders.add(new AdvertisementHeader(adv));
        }
        return advertisementHeaders;
    }


    @Override
    public List<Advertisement> findAllByUsername(String username) {
        List<Advertisement> advertisementListByUsername= advertisementRepository.findByUsername(username);
        return advertisementListByUsername;
    }

    @Override
    public Advertisement saveAdvertisement(Advertisement newAdvertisement) {
        return advertisementRepository.save(newAdvertisement);
    }


}
