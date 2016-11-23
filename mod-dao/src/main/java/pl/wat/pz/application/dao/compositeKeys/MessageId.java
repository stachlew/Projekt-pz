package pl.wat.pz.application.dao.compositeKeys;

import pl.wat.pz.application.dao.domain.Loan;

import java.io.Serializable;

/**
 * Created by DELL on 2016-11-23.
 */
public class MessageId implements Serializable {
    private Loan idLoan;
    private long seqNumber;

    public MessageId() {
    }

    public MessageId(Loan idLoan, long seqNumber) {
        this.idLoan = idLoan;
        this.seqNumber = seqNumber;
    }

    public Loan getIdLoan() {
        return idLoan;
    }

    public long getSeqNumber() {
        return seqNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageId messageId = (MessageId) o;

        if (seqNumber != messageId.seqNumber) return false;
        return idLoan != null ? idLoan.equals(messageId.idLoan) : messageId.idLoan == null;

    }

    @Override
    public int hashCode() {
        int result = idLoan != null ? idLoan.hashCode() : 0;
        result = 31 * result + (int) (seqNumber ^ (seqNumber >>> 32));
        return result;
    }
}
