package pl.wat.pz.application.logic.service;

/**
 * Created by DELL on 2016-12-28.
 */

import pl.wat.pz.application.dao.domain.Message;
import pl.wat.pz.application.dao.intermediateClass.Message.LoanMessage;
import pl.wat.pz.application.dao.intermediateClass.Message.MessageForm;

import java.util.List;

public interface MessageService {

    List<LoanMessage> findByIdLoan(long idLoan,String lang);

    void saveMessage(Message message);

    List<LoanMessage> convertMessageToLoanMesage(List<Message> messages,String lang);
    Message convertMessageFormToMessage(MessageForm messageForm,String username);

    int isMessageWithStatusTwo(long idLoan,String username);

    void readAllMessagesByUsernameInLoan(long idLoan,String username);
}
