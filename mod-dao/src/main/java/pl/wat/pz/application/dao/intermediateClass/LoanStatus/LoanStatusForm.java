package pl.wat.pz.application.dao.intermediateClass.LoanStatus;

/**
 * Created by Marian on 2016-12-30.
 */
public class LoanStatusForm {
    private String idLoan;
    private String statusName;

    public LoanStatusForm() {
    }

    public LoanStatusForm(String idLoan, String statusName) {
        this.idLoan = idLoan;
        this.statusName = statusName;
    }

    public String getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(String idLoan) {
        this.idLoan = idLoan;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
