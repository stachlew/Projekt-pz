package pl.wat.pz.application.web.validator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import pl.wat.pz.application.dao.intermediateClass.LoanStatus.LoanStatusForm;

public class LoanStatusFormValidatorTest extends TestCase {
    private LoanStatusForm loanStatusForm;
    private LoanStatusFormValidator loanStatusFormValidator;

    public LoanStatusFormValidatorTest(String name) {
        super(name);
    }

    @Before
    public void setUp() {
        loanStatusForm = new LoanStatusForm();
        loanStatusFormValidator = new LoanStatusFormValidator();
    }

    @Test
    public void test_id_loan_is_empty() {
        loanStatusForm.setStatusName("opened");

        Errors errors = new BeanPropertyBindingResult(loanStatusForm, "idLoan is empty.");
        loanStatusFormValidator.validate(loanStatusForm, errors);

        assertTrue("ID of loan is empty.", errors.hasErrors());
    }

    @Test
    public void test_id_loan_is_not_a_number() {
        loanStatusForm.setStatusName("opened");

        loanStatusForm.setIdLoan("123abc.50");

        Errors errors = new BeanPropertyBindingResult(loanStatusForm, "idLoan is not a number.");
        loanStatusFormValidator.validate(loanStatusForm, errors);

        assertTrue("ID of loan is not a number.", errors.hasErrors());
    }

    @Test
    public void test_id_loan_is_too_long() {
        loanStatusForm.setStatusName("opened");

        loanStatusForm.setIdLoan("12346758927367821912");

        Errors errors = new BeanPropertyBindingResult(loanStatusForm, "idLoan is too long.");
        loanStatusFormValidator.validate(loanStatusForm, errors);

        assertTrue("ID of loan is too long.", errors.hasErrors());
    }

    @Test
    public void test_status_name_is_empty() {
        loanStatusForm.setIdLoan("10");

        Errors errors = new BeanPropertyBindingResult(loanStatusForm, "statusName is empty.");
        loanStatusFormValidator.validate(loanStatusForm, errors);

        assertTrue("StatusName is empty.", errors.hasErrors());
    }

    @Test
    public void test_status_name_is_too_long() {
        loanStatusForm.setIdLoan("10");

        loanStatusForm.setStatusName("Neque porro quisquam est qui dolorem ipsu");

        Errors errors = new BeanPropertyBindingResult(loanStatusForm, "statusName is too long.");
        loanStatusFormValidator.validate(loanStatusForm, errors);

        assertTrue("StatusName is too long.", errors.hasErrors());
    }

    @Test
    public void test_loan_status_form_is_correct() {
        loanStatusForm.setIdLoan("10");
        loanStatusForm.setStatusName("opened");

        Errors errors = new BeanPropertyBindingResult(loanStatusForm, "Something went wrong.");
        loanStatusFormValidator.validate(loanStatusForm, errors);

        assertFalse("No errors should be.", errors.hasErrors());
    }
}
