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
@RequestMapping(value = "rest/usr/notifications")
public class NotificationsRestController {
    @Autowired
    LoanService loanService;

    @RequestMapping(value="/getLoan", method= RequestMethod.GET)
    public @ResponseBody
    List<LoanHeader> getLoan(Authentication auth) {
        String username = auth.getName();
        String locale = LocaleContextHolder.getLocale().getLanguage();
        return loanService.findLoanHeaderByUsername(username,locale);
    }
}
