package pl.wat.pz.application.web.validator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import pl.wat.pz.application.dao.intermediateClass.User.UserRegistered;

public class UserRegisteredValidatorTest extends TestCase {
    private UserRegistered userRegistered;
    private UserRegisteredValidator userRegisteredValidator;

    @Before
    public void setUp() {
        userRegistered = new UserRegistered();
        userRegisteredValidator = new UserRegisteredValidator();
    }

    @Test
    public void test_username_is_empty() {
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");


        Errors errors = new BeanPropertyBindingResult(userRegistered, "Username is empty.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Username is empty.", errors.hasErrors());
    }

    @Test
    public void test_username_length_is_less_than_4() {
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setUsername("xy");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Username is too short.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Username has less than 4 chars length.", errors.hasErrors());
    }

    @Test
    public void test_username_length_is_greater_than_50() {
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setUsername("Neque porro quisquam est qui dolorem ipsum quia doa");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Username is too long.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Username has greater than 50 chars length.", errors.hasErrors());
    }

    @Test
    public void test_password_is_empty() {
        userRegistered.setUsername("noname");
        userRegistered.setMail("ala.has.cat@cat.com");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Password is empty.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Password is empty.", errors.hasErrors());
    }

    @Test
    public void test_password_length_is_less_than_4() {
        userRegistered.setUsername("noname");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setPassword("xy");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Password is too short.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Password has less than 4 chars length.", errors.hasErrors());
    }

    @Test
    public void test_password_length_is_greater_than_255() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setPassword("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget " +
                "condimentum magna, convallis ornare purus. Phasellus suscipit odio et ipsum consequat sodales. " +
                "Maecenas non mollis lectus. Sed urna turpis, venenatis eget ipsum sed, tincidunt turpis duis.");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Password is too long.");
        userRegisteredValidator.validate(userRegistered, errors);


        assertTrue("Password has greater than 255 chars length.", errors.hasErrors());
    }

    @Test
    public void test_wrong_email_was_entered() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");

        userRegistered.setMail("test"); // POPRAWIĆ !!!


        Errors errors = new BeanPropertyBindingResult(userRegistered, "Email has wrong format.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Email has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_email_address_is_too_long() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");

        userRegistered.setMail("Neque porro quisquam est qui dolorem ipsum quia dol");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Email is too long.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Email is too long.", errors.hasErrors());
    }

    @Test
    public void test_phone_has_wrong_format() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setPhone("1234.");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Phone has wrong format.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Phone number has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_phone_number_is_too_long() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setPhone("1234567890123456");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Phone number is too long.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Phone number is too long.", errors.hasErrors());
    }

    @Test
    public void test_too_long_city_was_entered() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setCity("Neque porro quisquam est qui da");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "City name is too long.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("City name is too long.", errors.hasErrors());
    }

    @Test
    public void test_too_long_region_was_entered() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setRegionName("Neque porro quisquama");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "Region name is too long.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertTrue("Region name is too long.", errors.hasErrors());
    }

    @Test
    public void test_user_registered_is_correct() {
        userRegistered.setUsername("noname");
        userRegistered.setPassword("pass");
        userRegistered.setMail("ala.has.cat@cat.com");

        userRegistered.setPhone("123456789");
        userRegistered.setCity("Warsaw");
        userRegistered.setRegionName("Mazovia");

        Errors errors = new BeanPropertyBindingResult(userRegistered, "User registered is correct.");
        userRegisteredValidator.validate(userRegistered, errors);

        assertFalse("No errors should be.", errors.hasErrors());
    }
}
