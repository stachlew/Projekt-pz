package pl.wat.pz.application.logic.service;

import pl.wat.pz.application.dao.domain.LoanStatus;

import java.util.List;

/**
 * Created by DELL on 2016-12-10.
 */
public interface LoanStatusService {
    List<String> findAllLoanStatusName(String language);
    List<String> findLoanStatusNameAvailableToUser(long idLoan,String username,String language);
    List<String> convertLoanStatusListToLoanStatusNameList(List<LoanStatus> loanStatusList,String language);
}
