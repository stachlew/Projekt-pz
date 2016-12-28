package pl.wat.pz.application.logic.service;

/**
 * Created by DELL on 2016-12-28.
 */

import pl.wat.pz.application.dao.domain.Message;
import pl.wat.pz.application.dao.intermediateClass.Message.LoanMessage;

import java.util.List;

public interface MessageService {

    List<LoanMessage> findByIdLoan(long idLoan,String lang);

    List<LoanMessage> convertMessageToLoanMesage(List<Message> messages,String lang);
}