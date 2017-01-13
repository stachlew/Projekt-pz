package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanForm;

import java.sql.Date;
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
        if(loanForm.getDateFrom() != null && loanForm.getDateTo() != null) {

            boolean isDateFromCorrect = true;
            long df = loanForm.getDateFrom().getTime();
            long dt = loanForm.getDateTo().getTime();


            Date dateFrom = new Date(df);
            Date dateTo = new Date(dt);
            Date sqlDate = new Date(Calendar.getInstance().getTime().getTime());

            if(!(dateFrom.getYear() >= sqlDate.getYear() && dateFrom.getMonth() >= sqlDate.getMonth()
                    && dateFrom.getDay() >= sqlDate.getDay())) {
                errors.rejectValue("dateFrom", "Wrong dateFrom.");
                isDateFromCorrect = false;
            }
            if(!(dateTo.getYear() >= sqlDate.getYear() && dateTo.getMonth() >= sqlDate.getMonth()
                    && dateTo.getDay() >= sqlDate.getDay())) {
                errors.rejectValue("dateTo", "Wrong dateTo.");
            }
            else {
                if(isDateFromCorrect) {
                    if(!(dateTo.getYear() >= dateFrom.getYear() && dateTo.getMonth() >= dateTo.getMonth()
                            && dateTo.getDay() >= dateTo.getDay())) {
                        errors.rejectValue("dateFrom", "Wrong date range.");
                    }
                }
            }
        }
    }
}
