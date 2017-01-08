package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.Loan;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanForm;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanHeader;

import java.util.List;

/**
 * Created by Kamil on 2016-12-26.
 */
public interface LoanService {
    List<LoanHeader> findLoanHeaderByUsernameAndUserIsLender(String username,String lang);
    List<LoanHeader>findLoanHeaderByUsernameAndUserIsBorrower(String username,String lang);
    List<LoanHeader> findLoanHeaderByUsername(String username,int nrPage,String lang);
    int numberOfPage(String username);
    LoanHeader findOneLoanHeaderByIdLoan(long idLoan,String lang);
    boolean isMemberInLoan(String username, long idLoan);



    List<LoanHeader> convertLoanToLoanHeader(List<Loan> loans,String lang);

    void addLoan(LoanForm loanForm, String name);
    void changeLoanStatus(long idLoan,String statusName,String username);
}
