package pl.wat.pz.application.dao.domain;

import javax.persistence.*;

/**
 * Status wypożyczenia
 */
@Entity
public class LoanStatus {
    @Id
    @Column(name = "id_loan_status",length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLoanStatus;

    @Column(length = 40,nullable = false)
    private String name;

    public LoanStatus() {
    }

    public LoanStatus(String name) {
        this.name = name;
    }

    public long getIdLoanStatus() {
        return idLoanStatus;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
