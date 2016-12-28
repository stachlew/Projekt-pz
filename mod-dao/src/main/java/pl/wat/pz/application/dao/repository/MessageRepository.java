package pl.wat.pz.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.wat.pz.application.dao.compositeKeys.MessageId;
import pl.wat.pz.application.dao.domain.Loan;
import pl.wat.pz.application.dao.domain.Message;

import java.util.List;

/**
 * Created by DELL on 2016-11-23.
 */
public interface MessageRepository extends JpaRepository<Message,MessageId> {
    @Query("select m from Message m where idLoan.idLoan=?1")
    List<Message> findByIdLoan(long idLoan);

    @Modifying
    @Transactional
    @Query(value = "insert into Message(text,id_loan,id_sender) values (:text,:loan,:send)",nativeQuery = true)
    void addMessages(@Param(value = "text")String text,@Param("loan") long idLoan, @Param("use") String username);


}
