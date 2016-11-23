package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.pz.application.dao.compositeKeys.ObservationId;
import pl.wat.pz.application.dao.domain.Observation;

/**
 * Created by DELL on 2016-11-23.
 */
public interface ObservationRepository extends JpaRepository<Observation,ObservationId> {
}
