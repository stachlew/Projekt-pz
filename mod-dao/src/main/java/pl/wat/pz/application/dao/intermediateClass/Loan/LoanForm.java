package pl.wat.pz.application.dao.intermediateClass.Loan;

import java.sql.Date;

/**
 * Created by Marian on 2016-12-29.
 */
public class LoanForm {
    private long idAdvertisement;
    private Date dateFrom;
    private Date dateTo;

    public LoanForm() {
    }

    public void setidAdvertisement(long idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public long getidAdvertisement() {
        return idAdvertisement;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }
}
