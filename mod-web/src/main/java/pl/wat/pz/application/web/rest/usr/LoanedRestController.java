package pl.wat.pz.application.web.rest.usr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pl.wat.pz.application.dao.domain.Advertisement;
import pl.wat.pz.application.dao.domain.LoanStatus;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanForm;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanHeader;
import pl.wat.pz.application.dao.intermediateClass.LoanStatus.LoanStatusForm;
import pl.wat.pz.application.dao.intermediateClass.Message.LoanMessage;
import pl.wat.pz.application.dao.intermediateClass.Message.MessageForm;
import pl.wat.pz.application.logic.service.LoanService;
import pl.wat.pz.application.logic.service.LoanStatusService;
import pl.wat.pz.application.logic.service.MessageService;

import javax.xml.transform.sax.SAXSource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping(value = "rest/usr/loaned")
public class LoanedRestController {
    @Autowired
    LoanService loanService;
    @Autowired
    MessageService messageService;
    @Autowired
    LoanStatusService loanStatusService;

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
            if(loanHeader!=null){
                if(loanHeader.getLender().equals(username) || loanHeader.getBorrower().equals(username)){
                    messageService.readAllMessagesByUsernameInLoan(loanIdLong,username);
                    return loanHeader;
                }
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

    @RequestMapping(value = "/messages/createMessage", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void createItem(@RequestBody MessageForm messageForm, Authentication auth){
        if(loanService.isMemberInLoan(auth.getName(),messageForm.getIdLoan())){
            if(messageForm.getText().length()>0)
                messageService.saveMessage(messageService.convertMessageFormToMessage(messageForm,auth.getName()));
        }
    }

    @RequestMapping(value = "/createLoanRequest", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void createLoanRequest(@RequestBody LoanForm loanForm, Authentication auth){
        loanService.addLoan(loanForm, auth.getName());
    }

    @RequestMapping(value = "/changeLoanStatus", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void changeLoanRequest(@RequestBody LoanStatusForm form, Authentication auth){
        String lang = LocaleContextHolder.getLocale().getLanguage();
        try {
            Long longIdLoan = Long.parseLong(form.getIdLoan());
            LoanHeader header = loanService.findOneLoanHeaderByIdLoan(longIdLoan,lang);

            List<String> loanStatusNameAvailableToUser = loanStatusService.findLoanStatusNameAvailableToUser(longIdLoan, auth.getName(), lang);
            if(loanStatusNameAvailableToUser.contains(form.getStatusName())){
                loanService.changeLoanStatus(longIdLoan,form.getStatusName(),auth.getName());
            }
        }
        catch (NumberFormatException nfe){

        }
    }


}
