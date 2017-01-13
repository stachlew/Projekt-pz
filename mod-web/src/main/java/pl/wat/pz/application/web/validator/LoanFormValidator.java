package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanForm;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class LoanFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return LoanForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoanForm loanForm = (LoanForm) target;

        if(loanForm.getidAdvertisement() == null) {
            errors.rejectValue("idAdvertisement", "Empty idAdvertisement.");
        }
        else {
            if(loanForm.getidAdvertisement().length() > 19) {
                errors.rejectValue("idAdvertisement", "Too long idAdvertisement.");
            }
            else {
                try {
                    Long.parseLong(loanForm.getidAdvertisement());
                } catch (NumberFormatException e) {
                    errors.rejectValue("idAdvertisement", "Wrong type of idAdvertisement.");
                }
            }
        }

        if(loanForm.getDateFrom() == null) {
            errors.rejectValue("dateFrom", "Empty dateFrom.");
        }
        if(loanForm.getDateTo() == null) {
            errors.rejectValue("dateTo", "Empty dateTo.");
        }
//        if(loanForm.getDateFrom() != null && loanForm.getDateTo() != null) {
//
//            long df = loanForm.getDateFrom().getTime();
//            long dt = loanForm.getDateTo().getTime();
//
//            Date dateFrom = new Date(df);
//            Date dateTo = new Date(dt);
//
//            Calendar calendar = Calendar.getInstance();
//            Date sqlDate = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));;
//
//            if(dateFrom.compareTo(sqlDate) == -1) {
//                errors.rejectValue("dateFrom", "Wrong dateFrom.");
//            }
//            if(dateTo.compareTo(sqlDate) == -1) {
//                errors.rejectValue("dateTo", "Wrong dateTo.");
//            }
//            if(dateFrom.compareTo(dateTo) == 1) {
//                errors.rejectValue("dateTo", "Wrong dateTo.");
//            }
//        }
    }
}
