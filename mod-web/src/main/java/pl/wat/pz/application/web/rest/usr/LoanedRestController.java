package pl.wat.pz.application.web.rest.usr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.wat.pz.application.dao.intermediateClass.Loan.LoanHeader;
import pl.wat.pz.application.logic.service.LoanService;

import java.util.List;


@Controller
@RequestMapping(value = "rest/usr/loaned")
public class LoanedRestController {
    @Autowired
    LoanService loanService;

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
}
