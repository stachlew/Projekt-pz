package pl.wat.pz.application.dao.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Wypożyczenie
 */
@Entity
public class Loan {
    @Id
    @Column(name = "id_loan", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLoan;

    @Column(name = "date_from", nullable = false)
    private Date dateFrom;

    @Column(name = "date_to", nullable = false)
    private Date dateTo;

    @Column(name = "bail_value",length = 15,precision = 2,scale = 13 , nullable = true)
    private double bailValue;

    @Column(name = "charge_per_day",length = 15,precision = 2,scale = 13 , nullable = true)
    private double chargePerDay;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_advertisement")
    private Advertisement idAdvertisement;

    @ManyToOne(optional = false)
    @JoinColumn (name = "id_borrower")
    private User idBorrower;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_loan_status")
    private LoanStatus idLoanStatus;

    public Loan(Date dateFrom, Date dateTo, double bailValue, double chargePerDay, Advertisement idAdvertisement, User idBorrower) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.bailValue = bailValue;
        this.chargePerDay = chargePerDay;
        this.idAdvertisement = idAdvertisement;
        this.idBorrower = idBorrower;
    }

    public long getIdLoan() {
        return idLoan;
    }

    public Advertisement getIdAdvertisement() {
        return idAdvertisement;
    }

    public User getIdBorrower() {
        return idBorrower;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public double getBailValue() {
        return bailValue;
    }

    public void setBailValue(double bailValue) {
        this.bailValue = bailValue;
    }

    public double getChargePerDay() {
        return chargePerDay;
    }

    public void setChargePerDay(double chargePerDay) {
        this.chargePerDay = chargePerDay;
    }

    public LoanStatus getIdLoanStatus() {
        return idLoanStatus;
    }

    public void setIdLoanStatus(LoanStatus idLoanStatus) {
        this.idLoanStatus = idLoanStatus;
    }
}
