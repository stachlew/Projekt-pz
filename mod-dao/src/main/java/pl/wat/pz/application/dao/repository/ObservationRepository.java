package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.pz.application.dao.compositeKeys.ObservationId;
import pl.wat.pz.application.dao.domain.Observation;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */
public interface ObservationRepository extends JpaRepository<Observation,ObservationId> {

    @Query("select o from Observation o where o.idUser.username=?1")
    List<Observation> findByUsername(String username);


    @Modifying
    @Transactional
    @Query("delete from Observation o where o.idAdvertisement.idAdvertisement=?1 AND o.idUser.username=?2 ")
    void deleteWithIdAdverisementAndUsername(long idAdvertisement,String username);
}
