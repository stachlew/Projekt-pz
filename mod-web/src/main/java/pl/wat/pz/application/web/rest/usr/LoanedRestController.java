package pl.wat.pz.application.web.rest.usr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wat.pz.application.dao.intermediateClass.Loan.LoanHeader;
import pl.wat.pz.application.dao.intermediateClass.Message.LoanMessage;
import pl.wat.pz.application.logic.service.LoanService;
import pl.wat.pz.application.logic.service.MessageService;

import javax.xml.transform.sax.SAXSource;
import java.util.List;


@Controller
@RequestMapping(value = "rest/usr/loaned")
public class LoanedRestController {
    @Autowired
    LoanService loanService;
    @Autowired
    MessageService messageService;

    @RequestMapping(value="/getLender", method= RequestMethod.GET)
    public @ResponseBody
    List<LoanHeader> getLender(Authentication auth) {
        String username = auth.getName();
        String locale = LocaleContextHolder.getLocale().getLanguage();
        return loanService.findLoanHeaderByUsernameAndUserIsLender(username,locale);
    }

    @RequestMapping(value="/getBorrower", method= RequestMethod.GET)
    public @ResponseBody
    List<LoanHeader> getBorrower(Authentication auth) {
        String username = auth.getName();
        String locale = LocaleContextHolder.getLocale().getLanguage();
        return loanService.findLoanHeaderByUsernameAndUserIsBorrower(username,locale);
    }

    @RequestMapping(value="/details/{loanId}", method= RequestMethod.GET)
    public @ResponseBody
    LoanHeader getLoanDetails(Authentication auth,@PathVariable String loanId) {
        LoanHeader loanHeader;
        String locale = LocaleContextHolder.getLocale().getLanguage();
        String username = auth.getName();
        try {
            long loanIdLong = Long.parseLong(loanId.trim());
            loanHeader = loanService.findOneLoanHeaderByIdLoan(loanIdLong,locale);
            if(loanHeader.getLender().equals(username) || loanHeader.getBorrower().equals(username)){
                return loanHeader;
            }
        } catch (NumberFormatException nfe) {
            return null;
        }
        return null;
    }

    @RequestMapping(value="/messages/{loanId}", method= RequestMethod.GET)
    public @ResponseBody
    List<LoanMessage> getLoanDetailsMessages(Authentication auth,@PathVariable String loanId) {
        String locale = LocaleContextHolder.getLocale().getLanguage();
        String username = auth.getName();
        try {
            long loanIdLong = Long.parseLong(loanId.trim());
            if(loanService.isMemberInLoan(username,loanIdLong)){
                return messageService.findByIdLoan(loanIdLong,locale);
            }
        } catch (NumberFormatException nfe) {
            return null;
        }
        return null;
    }

}
