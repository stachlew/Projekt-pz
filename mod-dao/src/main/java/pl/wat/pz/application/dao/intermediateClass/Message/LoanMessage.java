package pl.wat.pz.application.dao.intermediateClass.Message;

import pl.wat.pz.application.dao.domain.Message;

/**
 * Created by DELL on 2016-12-28.
 */
public class LoanMessage {
    private Long idLoan;
    private long seqNumber;
    private String sender;
    private String text;
    private String status;

    public LoanMessage() {
    }
    public LoanMessage(Message msg,String lang){
        this.idLoan=msg.getIdLoan().getIdLoan();
        this.seqNumber=msg.getSeqNumber();
        this.sender=msg.getIdSender().getUsername();
        this.text=msg.getText();
        if(lang=="pl") {
            this.status = msg.getIdMessageState().getNamePL();
        }else{
            this.status= msg.getIdMessageState().getNameENG();
        }
    }

    public Long getIdLoan() {
        return idLoan;
    }

    public long getSeqNumber() {
        return seqNumber;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }
}
