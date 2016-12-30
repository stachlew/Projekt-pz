package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wat.pz.application.dao.domain.LoanStatus;

/**
 * Created by DELL on 2016-11-23.
 */
public interface LoanStatusRepository extends JpaRepository<LoanStatus,Long> {

    @Query("select s from LoanStatus s where namePL=?1 or nameENG=?1")
    public LoanStatus findLoanStatusByName(String name);
}
