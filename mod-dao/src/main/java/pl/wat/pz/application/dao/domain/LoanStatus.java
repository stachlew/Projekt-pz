package pl.wat.pz.application.dao.domain;

import javax.persistence.*;

/**
 * Status wypożyczenia
 */
@Entity
@Table(name = "loan_status")
public class LoanStatus {
    @Id
    @Column(name = "id_loan_status",length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLoanStatus;

    @Column(name = "name_pl",length = 40,nullable = false)
    private String namePL;

    @Column(name = "name_eng",length = 40,nullable = false)
    private String nameENG;

    public LoanStatus() {
    }

    public LoanStatus(String namePL, String nameENG) {
        this.namePL = namePL;
        this.nameENG = nameENG;
    }

    public long getIdLoanStatus() {
        return idLoanStatus;
    }


    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }

    public String getNameENG() {
        return nameENG;
    }

    public void setNameENG(String nameENG) {
        this.nameENG = nameENG;
    }
}
