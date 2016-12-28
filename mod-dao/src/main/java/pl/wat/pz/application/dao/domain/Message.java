package pl.wat.pz.application.dao.domain;

import org.hibernate.annotations.Check;
import pl.wat.pz.application.dao.compositeKeys.MessageId;
import pl.wat.pz.application.dao.intermediateClass.Message.MessageForm;

import javax.persistence.*;

/**
 * Wiadomość
 */
@Entity
@IdClass(MessageId.class)
public class Message {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_loan")
    private Loan idLoan;

    @Id
    @Column(name = "seq_number",length = 3)
    private long seqNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name ="id_sender" )
    private User idSender;

    @Column(length = 400)
    private String text;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_message_state")
    private MessageState idMessageState;

    public Message(Loan idLoan, long seqNumber, User idSender, String text) {
        this.idLoan = idLoan;
        this.seqNumber = seqNumber;
        this.idSender = idSender;
        this.text = text;
    }

    public Message(MessageForm msg){
        this.text=msg.getText();
    }


    public Loan getIdLoan() {
        return idLoan;
    }

    public long getSeqNumber() {
        return seqNumber;
    }

    public User getIdSender() {
        return idSender;
    }

    public String getText() {
        return text;
    }

    public MessageState getIdMessageState() {
        return idMessageState;
    }

    public void setIdLoan(Loan idLoan) {
        this.idLoan = idLoan;
    }

    public void setIdSender(User idSender) {
        this.idSender = idSender;
    }

    public void setIdMessageState(MessageState idMessageState) {
        this.idMessageState = idMessageState;
    }

    public Message() {
    }
}
