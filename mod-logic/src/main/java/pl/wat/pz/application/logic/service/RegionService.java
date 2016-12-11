package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.Region;

import java.util.List;

/**
 * Created by DELL on 2016-12-06.
 */
public interface RegionService {
    List<String> findAllRegionName();
    String loadRegionNameById(long regionId);
    Region loadRegionByName(String name);
}
