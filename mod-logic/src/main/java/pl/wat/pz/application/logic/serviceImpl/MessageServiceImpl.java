package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.LoanStatus;
import pl.wat.pz.application.dao.domain.Message;
import pl.wat.pz.application.dao.intermediateClass.Message.LoanMessage;
import pl.wat.pz.application.dao.intermediateClass.Message.MessageForm;
import pl.wat.pz.application.dao.repository.*;
import pl.wat.pz.application.logic.enumeric.LoanStatusEnum;
import pl.wat.pz.application.logic.service.LoanStatusService;
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
    @Autowired
    LoanStatusRepository loanStatusRepository;
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
    public int isMessageWithStatusUnread(long idLoan, String username) {
        return messageRepository.isMessageWithStatusUnread(idLoan,username);
    }

    @Override
    @Transactional
    public void readAllMessagesByUsernameInLoan(long idLoan, String username) {
        messageRepository.readAllMessagesByUsernameInLoan(idLoan,username);

    }

    @Override
    public void sendAutomaticMessage(long idLoan, String username, String statusName) {
        LoanStatus loanStatus = loanStatusRepository.findLoanStatusByName(statusName);
        if(loanStatus.getIdLoanStatus()== LoanStatusEnum.REJECTED.getId()){
            String messagesString="Użytkownik "+username+" anulowal wypożyczenie.\n User "+ username+ " ";
            //messageRepository.addMessages();
        }
    }


}
