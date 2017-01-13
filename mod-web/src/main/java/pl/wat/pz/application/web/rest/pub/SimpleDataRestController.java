package pl.wat.pz.application.web.rest.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;

import pl.wat.pz.application.dao.domain.ItemCategory;
import pl.wat.pz.application.logic.service.ItemCategoryService;
import pl.wat.pz.application.logic.service.LoanStatusService;
import pl.wat.pz.application.logic.service.RegionService;
import pl.wat.pz.application.logic.service.UserDetailsService;
import pl.wat.pz.application.web.wrapper.BooleanResponse;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "rest/pub/simpleData")
public class SimpleDataRestController {

    @Autowired
    RegionService regionService;

    @Autowired
    ItemCategoryService itemCategoryService;

    @Autowired
    LoanStatusService loanStatusService;

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value="/getRegions", method= RequestMethod.GET)
    public @ResponseBody List<String> getRegions() {
        return regionService.findAllRegionName();
    }


    @RequestMapping(value="/getCategories", method= RequestMethod.GET)
    public @ResponseBody List<String> getCategories() {
        Locale locale = LocaleContextHolder.getLocale();
        return itemCategoryService.findAllItemCategorName(locale.getLanguage());
    }

    @RequestMapping(value="/getLoanStatus", method= RequestMethod.GET)
    public @ResponseBody List<String> getLoanStatus() {
        Locale locale = LocaleContextHolder.getLocale();
        return loanStatusService.findAllLoanStatusName(locale.getLanguage());
    }

    @RequestMapping(value="/getLoanStatusByUser/{loanId}", method= RequestMethod.GET)
    public @ResponseBody List<String> getLoanStatusByUser(Authentication auth,@PathVariable String loanId) {
        Logger logger = Logger.getLogger(this.getClass().toString());
        if(auth!=null && !loanId.isEmpty()) {
            String lang = LocaleContextHolder.getLocale().getLanguage();
            String username = auth.getName();
            try {
                long loanIdLong = Long.parseLong(loanId.trim());
                return loanStatusService.findLoanStatusNameAvailableToUser(loanIdLong,username,lang);
            }
            catch (NumberFormatException nfe) {
                logger.error("getLoanStatusByUser() NumberFormatException "+loanId);
                return null;
            }
        }
        return null;
    }

    @RequestMapping(value="/checkExistUsername/{username}", method= RequestMethod.GET)
    public @ResponseBody
    BooleanResponse checkFreeUsername(@PathVariable String username) {
        boolean usernameExist = userDetailsService.exist(username);
        return new BooleanResponse(usernameExist);
    }


}
