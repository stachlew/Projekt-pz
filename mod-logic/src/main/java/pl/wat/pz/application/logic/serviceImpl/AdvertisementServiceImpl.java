package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.repository.AdvertisementRepository;
import pl.wat.pz.application.logic.service.AdvertisementService;

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
    public List<Advertisement> findAllAndSortOfLatest() {
        List<Advertisement> advertisementListSorted = advertisementRepository.findAll(new Sort(Sort.Direction.DESC, "dateAdded"));
        return advertisementListSorted;
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
