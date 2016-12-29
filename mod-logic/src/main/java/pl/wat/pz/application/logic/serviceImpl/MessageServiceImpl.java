package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Message;
import pl.wat.pz.application.dao.intermediateClass.Message.LoanMessage;
import pl.wat.pz.application.dao.intermediateClass.Message.MessageForm;
import pl.wat.pz.application.dao.repository.LoanRepository;
import pl.wat.pz.application.dao.repository.MessageRepository;
import pl.wat.pz.application.dao.repository.MessageStateRepository;
import pl.wat.pz.application.dao.repository.UserRepository;
import pl.wat.pz.application.logic.service.MessageService;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by DELL on 2016-12-28.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageStateRepository messageStateRepository;
    @Override
    public List<LoanMessage> findByIdLoan(long idLoan,String lang) {
        return convertMessageToLoanMesage(messageRepository.findByIdLoan(idLoan),lang);
    }

    @Override
    @Transactional
    public void saveMessage(Message message) {
        messageRepository.addMessages(message.getText(),message.getIdLoan().getIdLoan(),message.getIdSender().getUsername());
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

    @Override
    public Message convertMessageFormToMessage(MessageForm messageForm,String username) {
        Message message= new Message(messageForm);
        message.setIdLoan(loanRepository.findOne(messageForm.getIdLoan()));
        message.setIdSender(userRepository.findOne(username));
        return message;
    }

    @Override
    public int isMessageWithStatusTwo(long idLoan, String username) {
        return messageRepository.isMessageWithStatusTwo(idLoan,username);
    }

    @Override
    @Transactional
    public void readAllMessagesByUsernameInLoan(long idLoan, String username) {
        messageRepository.readAllMessagesByUsernameInLoan(idLoan,username);

    }

}
