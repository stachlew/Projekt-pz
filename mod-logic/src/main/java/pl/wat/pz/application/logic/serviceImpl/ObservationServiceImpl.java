package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.Observation;
import pl.wat.pz.application.dao.repository.ObservationRepository;
import pl.wat.pz.application.logic.intermediateClass.Advertisement.AdvertisementHeader;
import pl.wat.pz.application.logic.service.AdvertisementService;
import pl.wat.pz.application.logic.service.ObservationService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Małgosia on 2016-12-08.
 */
@Service
public class ObservationServiceImpl implements ObservationService {
    @Autowired
    ObservationRepository observationRepository;
    @Autowired
    AdvertisementService advertisementService;

    @Override
    public List<AdvertisementHeader> findByUsername(String username) {
        List<Observation> observationList = observationRepository.findByUsername(username);
        List<Advertisement> advertisementList = new LinkedList<>();
        for (Observation obs:observationList) {
            advertisementList.add(obs.getIdAdvertisement());
        }
        List<AdvertisementHeader> advertisementHeaderList= advertisementService.advertisementConvertToAdvertisementHeader(advertisementList);

        return advertisementHeaderList;
    }

    @Override
    public void deleteObservation(Long idAdvertisement, String username) {
        observationRepository.deleteWithIdAdverisementAndUsername(idAdvertisement,username);
    }
}
