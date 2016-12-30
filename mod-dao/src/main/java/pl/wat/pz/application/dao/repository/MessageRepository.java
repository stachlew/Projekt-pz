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
    void addMessages(@Param(value = "text")String text,@Param("loan") long idLoan, @Param("send") String username);

    @Query("select COUNT(m) from Message m where idLoan.idLoan=?1 and (idSender.username!=?2) and  idMessageState.idMessageState=2 ")
    int isMessageWithStatusUnread(long idLoan, String username);

    @Modifying
    @Transactional
    @Query(value = "update Message set id_message_state=1 where id_loan=:loan and id_sender!=:user", nativeQuery = true)
    void readAllMessagesByUsernameInLoan(@Param(value = "loan")long idLoan,@Param("user") String username);
}
