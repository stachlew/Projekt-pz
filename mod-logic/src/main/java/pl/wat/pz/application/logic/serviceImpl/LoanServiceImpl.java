package pl.wat.pz.application.logic.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Loan;
import pl.wat.pz.application.dao.domain.Message;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanForm;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanHeader;
import pl.wat.pz.application.dao.repository.AdvertisementRepository;
import pl.wat.pz.application.dao.repository.LoanRepository;
import pl.wat.pz.application.dao.repository.LoanStatusRepository;
import pl.wat.pz.application.dao.repository.UserRepository;
import pl.wat.pz.application.logic.service.LoanService;
import pl.wat.pz.application.logic.service.MessageService;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kamil on 2016-12-26.
 */
@Service("LoanService")
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    MessageService messageService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdvertisementRepository advertisementRepository;
    @Autowired
    LoanStatusRepository loanStatusRepository;

    @Override
    public List<LoanHeader> findLoanHeaderByUsernameAndUserIsLender(String username, String lang) {

        return convertLoanToLoanHeader(loanRepository.findByUsernameAndUserIsLender(username),lang);
    }

    @Override
    public List<LoanHeader> findLoanHeaderByUsernameAndUserIsBorrower(String username, String lang) {

        return convertLoanToLoanHeader(loanRepository.findByUsernameAndUserIsBorrower(username),lang);
    }

    @Override
    public List<LoanHeader> findLoanHeaderByUsername(String username, String lang) {
        List<LoanHeader> loanHeaders = convertLoanToLoanHeader(loanRepository.findByUsername(username), lang);
        for (LoanHeader l:loanHeaders
             ) {
                l.setMessageWithStatusTwo(messageService.isMessageWithStatusTwo(l.getIdLoan(),username));
        }
        return loanHeaders;
    }

    @Override
    public LoanHeader findOneLoanHeaderByIdLoan(long idLoan,String lang) {
        return new LoanHeader(loanRepository.findOne(idLoan),lang);
    }

    @Override
    public boolean isMemberInLoan(String username, long idLoan) {
        LoanHeader header = findOneLoanHeaderByIdLoan(idLoan,"pl");
        return header.getBorrower().equals(username) || header.getLender().equals(username);
    }


    @Override
    public List<LoanHeader> convertLoanToLoanHeader(List<Loan> loans,String lang) {
        List<LoanHeader> loanHeaders = new LinkedList<>();
        for (Loan l:loans)
        {
            loanHeaders.add(new LoanHeader(l, lang));
        }
        return loanHeaders;
    }

    @Override
    @Transactional
    @Modifying
    public void addLoan(LoanForm loanForm, String name) {
        Loan loan=new Loan(loanForm);
        loan.setIdBorrower(userRepository.findOne(name));
        loan.setIdAdvertisement(advertisementRepository.findOne(loanForm.getidAdvertisement()));
        loan.setIdLoanStatus(loanStatusRepository.findOne(2L));
       loanRepository.save(loan);

    }

}
