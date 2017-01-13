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
import pl.wat.pz.application.logic.service.LoanService;
import pl.wat.pz.application.web.wrapper.BooleanResponse;
import pl.wat.pz.application.web.wrapper.StringResponse;
import org.apache.log4j.Logger;
import java.util.List;

@Controller
@RequestMapping(value = "rest/usr/notifications")
public class NotificationsRestController {
    @Autowired
    LoanService loanService;

    @RequestMapping(value="/getNotifications/{pageNo}", method= RequestMethod.GET)
    public @ResponseBody
    List<LoanHeader> getLoan(Authentication auth, @PathVariable String pageNo) {
        Logger logger = Logger.getLogger(this.getClass().toString());
        String username = auth.getName();
        String locale = LocaleContextHolder.getLocale().getLanguage();
        try{
            int intPageNo = Integer.parseInt(pageNo);
            if(intPageNo>=0){
                return loanService.findLoanHeaderByUsername(username,intPageNo,locale);
            }
            return null;
        }catch (NumberFormatException e){
            logger.error("getLoan() NumberFormatException "+pageNo);
            return null;
        }
    }

    @RequestMapping(value = "/getNumberOfPages",method = RequestMethod.GET)
    public @ResponseBody
    StringResponse getNumberOfPager(Authentication auth){
        String username =  auth.getName();
        Integer countedPages = loanService.numberOfPage(username);
        StringResponse response = new StringResponse(countedPages.toString());
        return response;
    }



    @RequestMapping(value="/checkNotifications", method= RequestMethod.GET)
    public @ResponseBody
    BooleanResponse isNewNotificationsExists(Authentication auth) {
        String username = auth.getName();
        String locale = LocaleContextHolder.getLocale().getLanguage();
        List<LoanHeader> headers = loanService.findLoanHeaderByUsername(username,0,locale);
        boolean exist = false;
        for (LoanHeader header: headers) {
            if(header.getMessageWithStatusTwo()>0){
                exist=true;
                break;
            }
        }
        return new BooleanResponse(exist);
    }
}
