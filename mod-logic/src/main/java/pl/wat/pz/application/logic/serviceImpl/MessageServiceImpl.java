package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Message;
import pl.wat.pz.application.dao.intermediateClass.Message.LoanMessage;
import pl.wat.pz.application.dao.repository.MessageRepository;
import pl.wat.pz.application.logic.service.MessageService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by DELL on 2016-12-28.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Override
    public List<LoanMessage> findByIdLoan(long idLoan,String lang) {
        return convertMessageToLoanMesage(messageRepository.findByIdLoan(idLoan),lang);
    }

    @Override
    public List<LoanMessage> convertMessageToLoanMesage(List<Message> messages,String lang) {
      List<LoanMessage> loanMessages=new LinkedList<>();
        for (Message msg:messages)
        {
            loanMessages.add(new LoanMessage(msg,lang));
        }
        return loanMessages;
    }
}
