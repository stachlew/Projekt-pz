package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.pz.application.dao.domain.Advertisement;

/**
 * Created by DELL on 2016-11-23.
 */
public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {
}
