package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wat.pz.application.dao.domain.Loan;
import pl.wat.pz.application.dao.domain.LoanStatus;
import pl.wat.pz.application.dao.repository.LoanRepository;
import pl.wat.pz.application.dao.repository.LoanStatusRepository;
import pl.wat.pz.application.logic.enumeric.LoanStatusEnum;
import pl.wat.pz.application.logic.service.LoanService;
import pl.wat.pz.application.logic.service.LoanStatusService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by DELL on 2016-12-10.
 */

@Service
public class LoanStatusServiceImpl implements LoanStatusService {

    @Autowired
    LoanStatusRepository loanStatusRepository;
    @Autowired
    LoanService loanService;
    @Autowired
    LoanRepository loanRepository;

    @Override
    public List<String> findAllLoanStatusName(String language) {
        List<LoanStatus> loanStatusList = loanStatusRepository.findAll();
        List<String> loanStatusNames=new LinkedList<>();
        for (LoanStatus loanStatus:loanStatusList) {
            switch (language){
                case "pl":{
                    loanStatusNames.add(loanStatus.getNamePL());
                    break;
                }
                case "en":{
                    loanStatusNames.add(loanStatus.getNameENG());
                    break;
                }
            }
        }
        return loanStatusNames;
    }

    @Override
    public List<String> findLoanStatusNameAvailableToUser(long idLoan, String username, String language) {
        if(loanService.isMemberInLoan(username,idLoan)){
            Loan loan = loanRepository.findOne(idLoan);
            List<LoanStatus> loanStatusList = new LinkedList<>();
            if(loan.getIdBorrower().getUsername().equals(username)){
                if(loan.getIdLoanStatus().getIdLoanStatus()== LoanStatusEnum.OFFER.getId()){
                    loanStatusList.add(loanStatusRepository.findOne(LoanStatusEnum.CANCELED.getId()));
                }
                if (loan.getIdLoanStatus().getIdLoanStatus()==LoanStatusEnum.ACCEPTED.getId()){
                    loanStatusList.add(loanStatusRepository.findOne(LoanStatusEnum.CANCELED.getId()));
                }
            }
            else{
                if(loan.getIdLoanStatus().getIdLoanStatus()==LoanStatusEnum.OFFER.getId()){
                    loanStatusList.add(loanStatusRepository.findOne(LoanStatusEnum.REJECTED.getId()));
                    loanStatusList.add(loanStatusRepository.findOne(LoanStatusEnum.ACCEPTED.getId()));
                }
                if (loan.getIdLoanStatus().getIdLoanStatus()==LoanStatusEnum.ACCEPTED.getId()){
                    loanStatusList.add(loanStatusRepository.findOne(LoanStatusEnum.CANCELED.getId()));
                    loanStatusList.add(loanStatusRepository.findOne(LoanStatusEnum.IN_PROGRESS.getId()));
                }
                if (loan.getIdLoanStatus().getIdLoanStatus()==LoanStatusEnum.IN_PROGRESS.getId()){
                    loanStatusList.add(loanStatusRepository.findOne(LoanStatusEnum.COMPLETED.getId()));
                }

            }
            return convertLoanStatusListToLoanStatusNameList(loanStatusList,language);
        }

        return null;
    }

    @Override
    public LoanStatus findLoanStatusByName(String name) {
        return loanStatusRepository.findLoanStatusByName(name);
    }

    @Override
    public List<String> convertLoanStatusListToLoanStatusNameList(List<LoanStatus> loanStatusList,String language) {
        if (loanStatusList!=null){
            List<String> loanStatusNames= new LinkedList<>();
            for (LoanStatus loanStatus:loanStatusList) {
                switch (language){
                    case "pl":{
                        loanStatusNames.add(loanStatus.getNamePL());
                        break;
                    }
                    case "en":{
                        loanStatusNames.add(loanStatus.getNameENG());
                        break;
                    }
                }
            }
            return loanStatusNames;
        }
        return null;
    }
}
