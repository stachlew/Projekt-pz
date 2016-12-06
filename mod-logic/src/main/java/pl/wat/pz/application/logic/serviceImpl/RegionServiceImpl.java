package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.wat.pz.application.dao.domain.Region;
import pl.wat.pz.application.dao.repository.RegionRepository;
import pl.wat.pz.application.logic.service.RegionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016-12-06.
 */
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<String> findAllRegionName() {
        List<Region> regionList = regionRepository.findAll();
        List<String> regionListName= new ArrayList<>();
        for (Region region:regionList) {
            regionListName.add(region.getName());
        }
        return regionListName;
    }
}
