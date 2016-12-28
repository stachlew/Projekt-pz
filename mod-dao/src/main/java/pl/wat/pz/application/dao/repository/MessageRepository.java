package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wat.pz.application.dao.compositeKeys.MessageId;
import pl.wat.pz.application.dao.domain.Loan;
import pl.wat.pz.application.dao.domain.Message;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */
public interface MessageRepository extends JpaRepository<Message,MessageId> {
    @Query("select m from Message where idLoan.idLoan=?1")
    List<Message> findByIdLoan(long idLoan);
}
