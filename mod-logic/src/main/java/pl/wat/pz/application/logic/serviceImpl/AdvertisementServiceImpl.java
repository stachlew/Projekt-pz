package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    static final int sizeOfPage = 8;

    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<AdvertisementHeader> findAllAndSortOfLatest() {
        List<Advertisement> advertisementListSorted = advertisementRepository.findAll(new Sort(Sort.Direction.DESC, "dateAdded"));
        return this.advertisementConvertToAdvertisementHeader(advertisementListSorted);
    }

    @Override
    public List<AdvertisementHeader> findPageAndSortOfLatest(int nrPage) {
        Page<Advertisement> advertisementPage = advertisementRepository.findAll(new PageRequest(nrPage, sizeOfPage, new Sort(Sort.Direction.DESC, "dateAdded")));
        return this.advertisementConvertToAdvertisementHeader(advertisementPage.getContent());
    }

    @Override
    public List<AdvertisementHeader> findAllByUsername(String username) {
        List<Advertisement> advertisementListByUsername= advertisementRepository.findByUsername(username);
        return this.advertisementConvertToAdvertisementHeader(advertisementListByUsername);
    }

    @Override
    public AdvertisementDetails findOneByIdAdvertisement(Long idAdvertisement) {
        AdvertisementDetails advertisementDetails = null;
        Advertisement advertisement = advertisementRepository.findOne(idAdvertisement);
        if(advertisement!=null)
            advertisementDetails = new AdvertisementDetails(advertisement);

        return advertisementDetails;

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

    @Override
    public List<AdvertisementHeader> advertisementConvertToAdvertisementHeader(List<Advertisement> advertisements) {
        List<AdvertisementHeader> advertisementHeaders = new LinkedList<>();
        for (Advertisement adv:advertisements) {
            advertisementHeaders.add(new AdvertisementHeader(adv));
        }
        return advertisementHeaders;
    }

    @Override
    public List<AdvertisementDetails> advertisementConvertToAdvertisementDetails(List<Advertisement> advertisements) {
        List<AdvertisementDetails> advertisementDetailses = new LinkedList<>();
        for (Advertisement adv:advertisements) {
            advertisementDetailses.add(new AdvertisementDetails(adv));
        }
        return advertisementDetailses;
    }


}
