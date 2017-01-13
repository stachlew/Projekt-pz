package pl.wat.pz.application.dao.intermediateClass.Message;

/**
 * Created by DELL on 2016-12-28.
 */
public class MessageForm {
    public void setIdLoan(long idLoan) {
        this.idLoan = idLoan;
    }

    public void setText(String text) {
        this.text = text;
    }

    private long idLoan;
    private String text;

    public MessageForm() {
    }

    public long getIdLoan() {
        return idLoan;
    }

    public String getText() {
        return text;
    }

}
