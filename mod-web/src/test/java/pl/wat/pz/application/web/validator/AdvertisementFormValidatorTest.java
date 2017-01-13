package pl.wat.pz.application.web.validator;

        import junit.framework.TestCase;
        import org.junit.Before;
        import org.junit.Test;
        import org.springframework.validation.BeanPropertyBindingResult;
        import org.springframework.validation.Errors;
        import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;

public class AdvertisementFormValidatorTest extends TestCase {
    private AdvertisementForm advertisementForm;
    private AdvertisementFormValidator advertisementFormValidator;

    public AdvertisementFormValidatorTest(String name) {
        super(name);
    }

    @Before
    public void setUp() {
        advertisementForm = new AdvertisementForm();
        advertisementFormValidator = new AdvertisementFormValidator();
    }

    @Test
    public void test_title_of_advertisement_is_empty() {
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Empty title.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Title of advertisement is empty", errors.hasErrors());
    }

    @Test
    public void test_title_of_advertisement_should_have_more_than_4_chars() {
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setTitle("xy");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too short title.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Title of advertisement has too short length.", errors.hasErrors());
    }

    @Test
    public void test_title_of_advertisement_should_have_less_than_250_chars() {
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse " +
                "mattis, urna nec molestie sodales, erat leo lobortis mauris, id lacinia orci orci et mauris. " +
                "Maecenas vitae mattis orci. Phasellus eget sapien eget dui consequat faucibus turpis duis.");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long title.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Title of advertisement has too long length.", errors.hasErrors());
    }

    @Test
    public void test_bail_value_is_negative() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setBailValue(-123.5);

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Negative bailValue.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has negative bailValue.", errors.hasErrors());
    }

    @Test
    public void test_bail_value_is_too_long() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setBailValue(12345678.12);

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long bailValue.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has too long bailValue.", errors.hasErrors());
    }

    @Test
    public void test_charge_per_day_is_negative() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setChargePerDay(-123.5);

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Negative chargePerDay.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has negative chargePerDay.", errors.hasErrors());
    }

    @Test
    public void test_charge_per_day_is_too_long() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setChargePerDay(12345678.12);

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long chargePerDay.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has too long chargePerDay.", errors.hasErrors());
    }

    @Test
    public void test_advertisement_with_too_long_description() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut dictum " +
                "accumsan interdum. Ut a libero dolor. Fusce quis lacus elementum, porttitor purus id, eleifend risus. " +
                "Fusce facilisis tincidunt justo at convallis. In hendrerit et lacus nec sagittis. Pellentesque nec " +
                "nunc purus. Maecenas tempus sem vitae nibh dignissim luctus. Pellentesque magna libero, laoreet et " +
                "bibendum sed, tempus a nisi. Maecenas nec tellus auctor, lacinia neque et, ullamcorper risus. " +
                "Vestibulum sit amet lectus vitae nullam.");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long description.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has too long description.", errors.hasErrors());
    }

    @Test
    public void test_no_city_selected() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Empty city name.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has empty city name.", errors.hasErrors());
    }

    @Test
    public void test_city_name_is_too_long() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setCity("Neque porro quisquam est qui do");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long city.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has too long city name.", errors.hasErrors());
    }

    @Test
    public void test_no_region_selected() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setCategory("test");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Empty region name.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has empty region name.", errors.hasErrors());
    }

    @Test
    public void test_region_name_is_too_long() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        advertisementForm.setRegion("Neque porro quisquam ");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long region.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has too long region name.", errors.hasErrors());
    }

    @Test
    public void test_no_category_selected() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Empty category name.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has empty category name.", errors.hasErrors());
    }

    @Test
    public void test_category_is_too_long() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");

        advertisementForm.setCategory("Neque porro quisquam ");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long category.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue("Advertisement has too long category name.", errors.hasErrors());
    }

    @Test
    public void test_good_advertisement_is_correct() {
        advertisementForm.setTitle("My advertisement");
        advertisementForm.setBailValue(1234.96);
        advertisementForm.setChargePerDay(1234.96);
        advertisementForm.setDescription("Just anything.");
        advertisementForm.setCity("test");
        advertisementForm.setRegion("test");
        advertisementForm.setCategory("test");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Something went wrong.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertFalse("No errors should be.", errors.hasErrors());
    }

}
