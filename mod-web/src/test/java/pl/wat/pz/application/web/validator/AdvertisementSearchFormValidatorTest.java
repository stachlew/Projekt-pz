package pl.wat.pz.application.web.validator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementSearchForm;

public class AdvertisementSearchFormValidatorTest extends TestCase {
    private AdvertisementSearchForm advertisementSearchForm;
    private AdvertisementSearchFormValidator advertisementSearchFormValidator;

    public AdvertisementSearchFormValidatorTest(String name) {
        super(name);
    }

    @Before
    public void setUp() {
        advertisementSearchForm = new AdvertisementSearchForm();
        advertisementSearchFormValidator = new AdvertisementSearchFormValidator();
    }

    @Test
    public void test_searched_title_is_too_long() {
        advertisementSearchForm.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus et " +
                "scelerisque diam, at pulvinar elit. In hac habitasse platea dictumst. Aliquam eget lacinia tortor, " +
                "ac laoreet ante. Praesent sit amet nisi quis neque porttitor finibus. Donec est nullam.");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Too long title.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched title of advertisement is too long.", errors.hasErrors());
    }

    @Test
    public void test_searched_category_is_too_long() {
        advertisementSearchForm.setCategory("Neque porro quisquam ");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Too long category.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched name of category is too long.", errors.hasErrors());
    }

    @Test
    public void test_searched_region_is_too_long() {
        advertisementSearchForm.setRegion("Neque porro quisquam ");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Too long region.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched name of region is too long.", errors.hasErrors());
    }

    @Test
    public void test_searched_city_is_too_long() {
        advertisementSearchForm.setCity("Neque porro quisquam est qui do");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Too long city.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched name of city is too long.", errors.hasErrors());
    }

    @Test
    public void test_searched_charge_per_day_from_is_not_a_number() {
        advertisementSearchForm.setChargePerDayFrom("-3asd.67");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Wrong format of chargerPerDayFrom.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched charged per day from has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_searched_charge_per_day_to_is_not_a_number() {
        advertisementSearchForm.setChargePerDayTo("-3a.67");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Wrong format of chargerPerDayTo.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched charged per day to has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_searched_bail_value_from_is_not_a_number() {
        advertisementSearchForm.setBailValueFrom("-3a.67");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Wrong format of bailValueFrom.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched bail value from has wrong format.", errors.hasErrors());
    }

    @Test
    public void test_searched_bail_value_to_is_not_a_number() {
        advertisementSearchForm.setBailValueTo("-3a.67");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Wrong format of bailValueTo.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertTrue("Searched bail value from to wrong format.", errors.hasErrors());
    }

    @Test
    public void test_correct_search() {
        advertisementSearchForm.setTitle("My advertisement");
        advertisementSearchForm.setCategory("automotive");
        advertisementSearchForm.setRegion("mazovia");
        advertisementSearchForm.setCity("Warsaw");
        advertisementSearchForm.setChargePerDayFrom("12.5");
        advertisementSearchForm.setChargePerDayTo("18.5");
        advertisementSearchForm.setBailValueFrom("100.25");
        advertisementSearchForm.setBailValueTo("111.25");

        Errors errors = new BeanPropertyBindingResult(advertisementSearchForm, "Something went wrong.");
        advertisementSearchFormValidator.validate(advertisementSearchForm, errors);

        assertFalse("No errors should be.", errors.hasErrors());
    }
}
