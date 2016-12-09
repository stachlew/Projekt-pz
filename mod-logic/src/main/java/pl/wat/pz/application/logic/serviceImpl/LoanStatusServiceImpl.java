package pl.wat.pz.application.logic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.wat.pz.application.dao.domain.LoanStatus;
import pl.wat.pz.application.dao.repository.LoanStatusRepository;
import pl.wat.pz.application.logic.service.LoanStatusService;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by DELL on 2016-12-10.
 */
public class LoanStatusServiceImpl implements LoanStatusService {
    @Autowired
    LoanStatusRepository loanStatusRepository;
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
}
