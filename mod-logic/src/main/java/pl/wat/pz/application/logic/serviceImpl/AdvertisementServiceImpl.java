package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.ItemCategory;
import pl.wat.pz.application.dao.domain.Region;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementSearchForm;
import pl.wat.pz.application.dao.repository.AdvertisementRepository;
import pl.wat.pz.application.dao.repository.ItemCategoryRepository;
import pl.wat.pz.application.dao.repository.RegionRepository;
import pl.wat.pz.application.dao.repository.UserRepository;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementDetails;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
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
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<AdvertisementHeader> findPageAndSortOfLatest(int nrPage,String lang) {
        Page<Advertisement> advertisementPage = advertisementRepository.findByAdvertisementDeletedFalse(new PageRequest(nrPage, sizeOfPage, new Sort(Sort.Direction.DESC, "dateAdded")));
        return this.advertisementConvertToAdvertisementHeader(advertisementPage.getContent(),lang);
    }

    @Override
    public List<AdvertisementHeader> findAllByUsername(String username,String lang) {
        List<Advertisement> advertisementListByUsername= advertisementRepository.findByUsername(username);
        return this.advertisementConvertToAdvertisementHeader(advertisementListByUsername,lang);
    }

    @Override
    public AdvertisementDetails findOneByIdAdvertisement(Long idAdvertisement,String lang) {
        AdvertisementDetails advertisementDetails = null;
        Advertisement advertisement = advertisementRepository.findByIdAdvertisementAndAdvertisementDeletedFalse(idAdvertisement);
        if(advertisement!=null)
            advertisementDetails = new AdvertisementDetails(advertisement,lang);

        return advertisementDetails;

    }

    @Override
    public byte[] findImageByIdAdvertisement(long idAdvertisement) {
        Advertisement advertisement = advertisementRepository.findOne(idAdvertisement);
        return advertisement.getImage() ;
    }

    @Transactional
    @Modifying
    @Override
    public void modifyAdvertisementWithAdvertisementDetails(AdvertisementForm advertisementForm, Long idAdvertisement) {
        Advertisement advertisement = advertisementRepository.findByIdAdvertisementAndAdvertisementDeletedFalse(idAdvertisement);
        if (advertisement!=null) {
            advertisement.setBailValue(advertisementForm.getBailValue());
            advertisement.setChargePerDay(advertisementForm.getChargePerDay());
            advertisement.setCity(advertisementForm.getCity());
            advertisement.setDescription(advertisementForm.getDescription());
            advertisement.setTitle(advertisementForm.getTitle());
            advertisement.setImage(advertisementForm.getImage());
            advertisement.setIdItemCategory(itemCategoryRepository.findOneByName(advertisementForm.getCategory()));
            advertisement.setIdRegion(regionRepository.findOneByName(advertisementForm.getRegion()));
            advertisementRepository.save(advertisement);
        }

    }


    @Override
    @Transactional
    public Advertisement saveAdvertisement(Advertisement newAdvertisement) {
        return advertisementRepository.save(newAdvertisement);
    }

    @Override
    @Transactional
    @Modifying
    public void delete(Long idAdvertisement,String username) {
        Advertisement advertisement = advertisementRepository.findByIdAdvertisementAndAdvertisementDeletedFalse(idAdvertisement);
        if(advertisement.getIdUser().getUsername().equals(username)) {
            advertisement.setAdvertisementDeleted(true);
            advertisementRepository.save(advertisement);
        }

    }

    @Override
    public List<AdvertisementHeader> advertisementConvertToAdvertisementHeader(List<Advertisement> advertisements,String lang) {
        List<AdvertisementHeader> advertisementHeaders = new LinkedList<>();
        for (Advertisement adv:advertisements) {
            advertisementHeaders.add(new AdvertisementHeader(adv,lang));
        }
        return advertisementHeaders;
    }

    @Override
    public List<AdvertisementDetails> advertisementConvertToAdvertisementDetails(List<Advertisement> advertisements,String lang) {
        List<AdvertisementDetails> advertisementDetailses = new LinkedList<>();
        for (Advertisement adv:advertisements) {
            advertisementDetailses.add(new AdvertisementDetails(adv,lang));
        }
        return advertisementDetailses;
    }

    @Override
    public Advertisement convertAdvertisementFormToAdvertisement(AdvertisementForm form, String username) {
        Advertisement advert = new Advertisement(form);
        advert.setIdRegion(regionRepository.findOneByName(form.getRegion()));
        advert.setIdItemCategory(itemCategoryRepository.findOneByName(form.getCategory()));
        advert.setIdUser(userRepository.findOne(username));
        return advert;
    }


    @Override
    @Transactional
    public List<AdvertisementHeader> findByFilter(AdvertisementSearchForm searchForm, String lang) {
        String idCategoryString= new String();
        String idRegionString= new String();
        String titleString = new String();
        String cityString = new String();
        String  bailValueFromString = new String();
        String bailValueToString=new String();
        String chargePerDayFrom=new String();
        String chargePerDayTo=new String();
        ItemCategory itemCategory = itemCategoryRepository.findOneByName(searchForm.getCategory());
        Region region = regionRepository.findOneByName(searchForm.getRegion());
        if(searchForm.getTitle()!=null){
            titleString=searchForm.getTitle();
        }
        if(itemCategory != null) {
            long idItemCategory = itemCategory.getIdItemCategory();
           idCategoryString = String.valueOf(idItemCategory);
        }
        if(region != null) {
            long idRegion = region.getIdRegion();
            idRegionString = String.valueOf(idRegion);
        }
        if(searchForm.getCity()!=null){
            cityString=searchForm.getCity();
        }
        if(searchForm.getBailValueFrom()!=null) {
            bailValueFromString = String.valueOf(searchForm.getBailValueFrom());
        }
        if(searchForm.getBailValueTo()!=null) {
             bailValueToString = String.valueOf(searchForm.getBailValueTo());
        }
        if(searchForm.getChargePerDayFrom()!=null) {
           chargePerDayFrom = String.valueOf(searchForm.getChargePerDayFrom());
        }
        if(searchForm.getChargePerDayTo()!=null) {
            chargePerDayTo = String.valueOf(searchForm.getChargePerDayTo());
        }




        advertisementRepository.findAdvertisementWithParam(titleString,
                idCategoryString,
                idRegionString,
                cityString,
                bailValueFromString,
                bailValueToString,
                chargePerDayFrom,
                chargePerDayTo
                );
        List<Advertisement> byParameters = advertisementRepository.findByParameters();

        if(byParameters!=null) {
            return advertisementConvertToAdvertisementHeader(byParameters, lang);
        }
        else
            return null;
        }


}
