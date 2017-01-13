package pl.wat.pz.application.web.validator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import pl.wat.pz.application.dao.intermediateClass.User.UserForm;

public class UserFormValidatorTest extends TestCase {
    private UserForm userForm;
    private UserFormValidator userFormValidator;

    public UserFormValidatorTest(String name) {
        super(name);
    }

    @Before
    public void setUp() {
        userForm = new UserForm();
        userFormValidator = new UserFormValidator();
    }

    @Test
    public void test_entered_password_is_too_long() {
        userForm.setPassword("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque " +
                "tincidunt placerat enim non tempor. Pellentesque rutrum eu massa nec efficitur. Cras " +
                "fermentum nisl ac lectus varius imperdiet. Cras porta accumsan maximus. Donec eget " +
                "leo a mauris amet.");

        Errors errors = new BeanPropertyBindingResult(userForm, "Password is too long");
        userFormValidator.validate(userForm, errors);

        assertTrue("Password is too long", errors.hasErrors());
    }

    @Test
    public void test_wrong_email_was_entered() {
        userForm.setPassword("pass");

        userForm.setMail("test");

        Errors errors = new BeanPropertyBindingResult(userForm, "Email has wrong format.");
        userFormValidator.validate(userForm, errors);

        assertTrue("Email has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_email_address_is_too_long() {
        userForm.setPassword("pass");

        userForm.setMail("Neque porro quisquam est qui dolorem ipsum quia dol");

        Errors errors = new BeanPropertyBindingResult(userForm, "Email is too long.");
        userFormValidator.validate(userForm, errors);

        assertTrue("Email is too long.", errors.hasErrors());
    }

    @Test
    public void test_phone_has_wrong_format() {
        userForm.setPassword("pass");

        userForm.setPhone("1234.");

        Errors errors = new BeanPropertyBindingResult(userForm, "Phone has wrong format.");
        userFormValidator.validate(userForm, errors);

        assertTrue("Phone number has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_phone_number_is_too_long() {
        userForm.setPassword("pass");

        userForm.setPhone("1234567890123456");

        Errors errors = new BeanPropertyBindingResult(userForm, "Phone number is too long.");
        userFormValidator.validate(userForm, errors);

        assertTrue("Phone number is too long.", errors.hasErrors());
    }

    @Test
    public void test_too_long_city_was_entered() {
        userForm.setPassword("pass");

        userForm.setCity("Neque porro quisquam est qui da");

        Errors errors = new BeanPropertyBindingResult(userForm, "City name is too long.");
        userFormValidator.validate(userForm, errors);

        assertTrue("City name is too long.", errors.hasErrors());
    }

    @Test
    public void test_too_long_region_was_entered() {
        userForm.setPassword("pass");

        userForm.setRegionName("Neque porro quisquama");

        Errors errors = new BeanPropertyBindingResult(userForm, "Region name is too long.");
        userFormValidator.validate(userForm, errors);

        assertTrue("Region name is too long.", errors.hasErrors());
    }

    @Test
    public void test_user_form_is_correct() {
        userForm.setPassword("pass");
        userForm.setMail("ala.has@cat.com");
        userForm.setPhone("123456789");
        userForm.setCity("Warsaw");
        userForm.setRegionName("Mazovia");

        Errors errors = new BeanPropertyBindingResult(userForm, "User form is correct.");
        userFormValidator.validate(userForm, errors);

        assertFalse("No errors should be.", errors.hasErrors());
    }
}
