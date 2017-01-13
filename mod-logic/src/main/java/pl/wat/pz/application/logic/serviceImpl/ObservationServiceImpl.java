package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.compositeKeys.ObservationId;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.Observation;
import pl.wat.pz.application.dao.domain.User;
import pl.wat.pz.application.dao.repository.AdvertisementRepository;
import pl.wat.pz.application.dao.repository.ObservationRepository;
import pl.wat.pz.application.dao.repository.UserRepository;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;
import pl.wat.pz.application.logic.service.ObservationService;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by Małgosia on 2016-12-08.
 */
@Service
public class ObservationServiceImpl implements ObservationService {
    @Autowired
    ObservationRepository observationRepository;
    @Autowired
    AdvertisementService advertisementService;
    @Autowired
    AdvertisementRepository advertisementRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<AdvertisementHeader> findByUsername(String username,String lang) {
        List<Observation> observationList = observationRepository.findByUsername(username);
        List<Advertisement> advertisementList = new LinkedList<>();
        for (Observation obs:observationList) {
            advertisementList.add(obs.getIdAdvertisement());
        }
        List<AdvertisementHeader> advertisementHeaderList= advertisementService.advertisementConvertToAdvertisementHeader(advertisementList,lang);

        return advertisementHeaderList;
    }

    @Override
    public void deleteObservation(Long idAdvertisement, String username) {
        observationRepository.deleteWithIdAdverisementAndUsername(idAdvertisement,username);
    }

    @Override
    public void saveObservation(String username, String adId) {
        Logger logger = Logger.getLogger(this.getClass().toString());
        User user = userRepository.findOne(username);
        long idAd=0;
        try{
            idAd = Long.parseLong(adId);
        }
        catch (NumberFormatException e){
            logger.error("saveObservation() NumberFormatException "+adId);
        }
        Advertisement advert = advertisementRepository.findOne(idAd);
        ObservationId observationId = new ObservationId(advert,user);
        if(!observationRepository.exists(observationId)){
            observationRepository.addObservation(idAd,username);
        }

    }

    @Override
    public boolean isObserved(String username, String adId) {
        Logger logger = Logger.getLogger(this.getClass().toString());
        User user = userRepository.findOne(username);
        long idAd=0;
        try{
            idAd = Long.parseLong(adId);
        }
        catch (NumberFormatException e){
            logger.error("isObserved() NumberFormatException "+adId);
        }
        Advertisement advert = advertisementRepository.findOne(idAd);
        ObservationId observationId = new ObservationId(advert,user);
        if(observationRepository.exists(observationId))
            return true;
        else
            return false;
    }
}
