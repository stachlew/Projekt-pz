package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.ItemCategory;
import pl.wat.pz.application.dao.domain.Region;
import pl.wat.pz.application.dao.repository.AdvertisementRepository;
import pl.wat.pz.application.dao.repository.ItemCategoryRepository;
import pl.wat.pz.application.dao.repository.RegionRepository;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DELL on 2016-11-30.
 */
@Service("AdvertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

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
    public List<AdvertisementHeader> findAllByUsernameAndConvertToAdvertisementHeader(String username) {
        List<Advertisement> advertisementListByUsername= advertisementRepository.findByUsername(username);
        List<AdvertisementHeader> advertisementHeaders = new LinkedList<>();
        for (Advertisement adv:advertisementListByUsername) {
            advertisementHeaders.add(new AdvertisementHeader(adv));
        }
        return advertisementHeaders;
    }

    @Override
    public AdvertisementDetails findOneByIdAdvertisementAndConvertToAdvertisementDetails(Long idAdvertisement) {
        return new AdvertisementDetails(advertisementRepository.findOne(idAdvertisement));

    }

    @Transactional
    @Override
    public void modifyAdvertisementWithAdvertisementDetails(AdvertisementDetails advertisementDetails) {
        Advertisement advertisement = advertisementRepository.findOne(advertisementDetails.getIdAdvertisement());

        advertisement.setBailValue(advertisementDetails.getBailValue());
        advertisement.setChargePerDay(advertisementDetails.getChargePerDay());
        advertisement.setCity(advertisementDetails.getCity());
        advertisement.setDateAdded(advertisementDetails.getDateAdded());
        advertisement.setDescription(advertisementDetails.getDescription());
        advertisement.setTitle(advertisementDetails.getTitle());
        advertisement.setImage(advertisement.getImage());

        if(!advertisement.getIdItemCategory().getNamePL().equals(advertisementDetails.getCategoryNamePL())){
            ItemCategory category = itemCategoryRepository.findOneByNamePL(advertisementDetails.getCategoryNamePL());
            advertisement.setIdItemCategory(category);
        }
        if(!advertisement.getIdRegion().getName().equals(advertisementDetails.getRegionName())){
            Region region = regionRepository.findOneByName(advertisementDetails.getRegionName());
            advertisement.setIdRegion(region);
        }

        advertisementRepository.save(advertisement);
    }


    @Override
    public Advertisement saveAdvertisement(Advertisement newAdvertisement) {
        return advertisementRepository.save(newAdvertisement);
    }


}
