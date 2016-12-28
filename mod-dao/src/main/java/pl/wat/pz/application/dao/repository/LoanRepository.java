package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wat.pz.application.dao.domain.Loan;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */
public interface LoanRepository extends JpaRepository<Loan,Long> {

    @Query("select l from Loan l where l.idAdvertisement.idUser.username=?1 and (l.idLoanStatus.idLoanStatus=3 or l.idLoanStatus.idLoanStatus=4 )")
    List<Loan> findByUsernameAndUserIsLender(String username);

    @Query("select l from Loan l where l.idBorrower.username=?1 and (l.idLoanStatus.idLoanStatus=3 or l.idLoanStatus.idLoanStatus=4 )")
    List<Loan> findByUsernameAndUserIsBorrower(String username);

    @Query("select l from Loan l where l.idBorrower.username=?1 or l.idAdvertisement.idUser.username=?1")
    List<Loan> findByUsername(String username);
}
