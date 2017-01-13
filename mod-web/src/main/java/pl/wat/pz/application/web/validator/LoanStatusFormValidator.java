package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.LoanStatus.LoanStatusForm;

public class LoanStatusFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return LoanStatusForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoanStatusForm loanStatusForm = (LoanStatusForm) target;

        if(loanStatusForm.getIdLoan() == null) {
            errors.rejectValue("idLoan", "Empty idLoan.");
        }
        else if(loanStatusForm.getIdLoan().length() <= 19) {
            try {
                Long.parseLong(loanStatusForm.getIdLoan());
            } catch (NumberFormatException e) {
                errors.rejectValue("idLoan", "IdLoan - not a number.");
            }
        }
        else {
            errors.rejectValue("idLoan", "Too long idLoan.");
        }

        if(loanStatusForm.getStatusName() == null) {
            errors.rejectValue("statusName", "Empty statusName.");
        }
        else if(loanStatusForm.getStatusName().length() > 40) {
            errors.rejectValue("statusName", "Too long statusName.");
        }

    }
}
