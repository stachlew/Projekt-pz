package pl.wat.pz.application.logic.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Loan;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanHeader;
import pl.wat.pz.application.dao.repository.LoanRepository;
import pl.wat.pz.application.logic.service.LoanService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kamil on 2016-12-26.
 */
@Service("LoanService")
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepository loanRepository;

    @Override
    public List<LoanHeader> findLoanHeaderByUsernameAndUserIsLender(String username, String lang) {

        return convertLoanToLoanHeader(loanRepository.findByUsernameAndUserIsLender(username),lang);
    }

    @Override
    public List<LoanHeader> findLoanHeaderByUsernameAndUserIsBorrower(String username, String lang) {

        return convertLoanToLoanHeader(loanRepository.findByUsernameAndUserIsBorrower(username),lang);
    }




    @Override
    public List<LoanHeader> convertLoanToLoanHeader(List<Loan> loans,String lang) {
        List<LoanHeader> loanHeaders = new LinkedList<>();
        for (Loan l:loans)
        {
            loanHeaders.add(new LoanHeader(l,lang));
        }
        return loanHeaders;
    }
}
