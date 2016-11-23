package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wat.pz.application.dao.domain.LoanStatus;

/**
 * Created by DELL on 2016-11-23.
 */
public interface LoanStatusRepository extends JpaRepository<LoanStatus,Long> {
}
