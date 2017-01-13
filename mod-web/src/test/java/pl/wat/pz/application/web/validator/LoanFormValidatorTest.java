package pl.wat.pz.application.web.validator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import pl.wat.pz.application.dao.intermediateClass.Loan.LoanForm;

import java.sql.Date;
import java.util.Calendar;

public class LoanFormValidatorTest extends TestCase {
    private LoanForm loanForm;
    private LoanFormValidator loanFormValidator;

    public LoanFormValidatorTest(String name) {
        super(name);
    }

    @Before
    public void setUp() {
        loanForm = new LoanForm();
        loanFormValidator = new LoanFormValidator();
    }

    @Test
    public void test_id_advertisement_is_empty() {
        loanForm.setDateFrom(new Date(Calendar.getInstance().getTime().getTime()));
        loanForm.setDateTo(new Date(Calendar.getInstance().getTime().getTime()));

        Errors errors = new BeanPropertyBindingResult(loanForm, "idAdvertisement is empty.");
        loanFormValidator.validate(loanForm, errors);

        assertTrue("ID of advertisement is empty.", errors.hasErrors());
    }

    @Test
    public void test_id_advertisement_has_wrong_format() {
        loanForm.setDateFrom(new Date(Calendar.getInstance().getTime().getTime()));
        loanForm.setDateTo(new Date(Calendar.getInstance().getTime().getTime()));

        loanForm.setidAdvertisement("123abc.5");

        Errors errors = new BeanPropertyBindingResult(loanForm, "Wrong format of idAdvertisement.");
        loanFormValidator.validate(loanForm, errors);

        assertTrue("ID of advertisement has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_id_advertisement_is_too_long() {
        loanForm.setDateFrom(new Date(Calendar.getInstance().getTime().getTime()));
        loanForm.setDateTo(new Date(Calendar.getInstance().getTime().getTime()));

        loanForm.setidAdvertisement("12346758927367821912");

        Errors errors = new BeanPropertyBindingResult(loanForm, "idAdvertisement is too long.");
        loanFormValidator.validate(loanForm, errors);

        assertTrue("ID of advertisement is too long.", errors.hasErrors());
    }

    @Test
    public void test_date_from_is_not_selected() {
        loanForm.setDateTo(new Date(Calendar.getInstance().getTime().getTime()));
        loanForm.setidAdvertisement("1234");

        Errors errors = new BeanPropertyBindingResult(loanForm, "DateFrom is not selected.");
        loanFormValidator.validate(loanForm, errors);

        assertTrue("DateFrom is not selected.", errors.hasErrors());
    }

    @Test
    public void test_date_to_is_not_selected() {
        loanForm.setDateFrom(new Date(Calendar.getInstance().getTime().getTime()));
        loanForm.setidAdvertisement("1234");

        Errors errors = new BeanPropertyBindingResult(loanForm, "DateTo is not selected.");
        loanFormValidator.validate(loanForm, errors);

        assertTrue("DateTo is not selected.", errors.hasErrors());
    }

    @Test
    public void test_both_dates_are_empty() {
        loanForm.setidAdvertisement("1234");

        Errors errors = new BeanPropertyBindingResult(loanForm, "No dates selected.");
        loanFormValidator.validate(loanForm, errors);

        assertTrue("No dates selected.", errors.hasErrors());
    }

    @Test // POPRAWIĆ !!!
    public void test_wrong_dates_were_selected() {
        loanForm.setidAdvertisement("1234");

        loanForm.setDateFrom(new Date(2016, 0, 1));
        loanForm.setDateTo(new Date(2015, 0, 1));

        Errors errors = new BeanPropertyBindingResult(loanForm, "User selected wrong dates.");
        loanFormValidator.validate(loanForm, errors);

        assertTrue("Wrong dates were selected.", errors.hasErrors());
    }

    @Test // POPRAWIĆ !!!
    public void test_correct_loan_form() {
        loanForm.setidAdvertisement("1234");

        loanForm.setDateFrom(new Date(2017, 0, 14));
        loanForm.setDateTo(new Date(2017, 0, 16));

        Errors errors = new BeanPropertyBindingResult(loanForm, "Something went wrong.");
        loanFormValidator.validate(loanForm, errors);

        assertFalse("No errors should be.", errors.hasErrors());
    }
}
