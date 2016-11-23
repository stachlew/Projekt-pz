package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.pz.application.dao.domain.Region;

/**
 * Created by DELL on 2016-11-23.
 */
public interface RegionRepository extends JpaRepository<Region,Long> {
}
