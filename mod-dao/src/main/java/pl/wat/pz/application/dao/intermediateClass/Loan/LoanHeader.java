package pl.wat.pz.application.dao.intermediateClass.Loan;

import pl.wat.pz.application.dao.domain.Loan;

import java.sql.Date;

/**
 * Created by Kamil on 2016-12-26.
 */
public class LoanHeader {
    private long idLoan;
    private Date dateFrom;
    private Date dateTo;
    private long idAdvertisement;
    private String title;
    private String borrower;
    private String lender;
    private String loanStatus;
    private double bailValue;
    private double chargePerDay;
    private String phoneNumberOfBorrower;
    private String phoneNumberOfLender;
    private int messageWithStatusTwo;

    public LoanHeader() {
    }

    public LoanHeader(Loan loan,String lang) {
        this.idLoan=loan.getIdLoan();
        this.dateFrom=loan.getDateFrom();
        this.dateTo=loan.getDateTo();
        this.idAdvertisement=loan.getIdAdvertisement().getIdAdvertisement();
        this.title=loan.getIdAdvertisement().getTitle();
        this.borrower=loan.getIdBorrower().getUsername();
        this.lender=loan.getIdAdvertisement().getIdUser().getUsername();
        if(lang.equals("pl")) {
            this.loanStatus = loan.getIdLoanStatus().getNamePL();
        }else{
            this.loanStatus=loan.getIdLoanStatus().getNameENG();
        }
        this.bailValue=loan.getBailValue();
        this.chargePerDay=loan.getChargePerDay();
        this.phoneNumberOfBorrower=loan.getIdBorrower().getDetails().getPhone();
        this.phoneNumberOfLender=loan.getIdAdvertisement().getIdUser().getDetails().getPhone();
    }

    public long getIdLoan() {
        return idLoan;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public long getIdAdvertisement() {
        return idAdvertisement;
    }

    public String getTitle() {
        return title;
    }

    public String getBorrower() {
        return borrower;
    }

    public String getLender() {
        return lender;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public double getBailValue() {
        return bailValue;
    }

    public double getChargePerDay() {
        return chargePerDay;
    }

    public int getMessageWithStatusTwo() {
        return messageWithStatusTwo;
    }

    public void setMessageWithStatusTwo(int messageWithStatusTwo) {
        this.messageWithStatusTwo = messageWithStatusTwo;
    }

    public String getPhoneNumberOfBorrower() {
        return phoneNumberOfBorrower;
    }

    public void setPhoneNumberOfBorrower(String phoneNumberOfBorrower) {
        this.phoneNumberOfBorrower = phoneNumberOfBorrower;
    }

    public String getPhoneNumberOfLender() {
        return phoneNumberOfLender;
    }

    public void setPhoneNumberOfLender(String phoneNumberOfLender) {
        this.phoneNumberOfLender = phoneNumberOfLender;
    }
}
