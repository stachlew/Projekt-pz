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

        advertisementForm.setCategory("motoryzacja");
        advertisementForm.setTitle("Lorem ipsum");
        advertisementForm.setRegion("pomorskie");
        advertisementForm.setCity("Sopot");
    }

    @Test
    public void testValidatorWithTooShortTitle() {
        advertisementForm.setTitle("sa");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too short title.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue(errors.hasErrors());
    }

    @Test
    public void testValidatorWithTooLongTitle() {
        advertisementForm.setTitle("Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit. Proin congue, eros id ornare malesuada, arcu augue " +
                "dictum odio, nec mattis libero nibh non erat. Donec a lectus sed " +
                "neque ultrices faucibus vel nec nunc. Donec ac tellus nec ante aliquet nullam.");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long title.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue(errors.hasErrors());
    }

    @Test
    public void testValidatorWithTooLongBailValue() {
        advertisementForm.setBailValue(98473625.12);

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long bailValue.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue(errors.hasErrors());
    }

    @Test
    public void testValidatorWithTooLongChargePerDay() {
        advertisementForm.setChargePerDay(98473625.12);

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long chargePerDay.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue(errors.hasErrors());
    }

    @Test
    public void testValidatorWithTooLongDescription() {
        advertisementForm.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing " +
                "elit. Nam scelerisque hendrerit orci sed scelerisque. Nam molestie consectetur ipsum " +
                "vitae luctus. Sed non mi sed sapien tempor tincidunt. Mauris vehicula arcu non lacinia " +
                "placerat. Aenean risus nibh, elementum sed hendrerit et, viverra a neque. Maecenas ut " +
                "felis congue ipsum feugiat blandit sed eu urna. Aenean pretium posuere erat, sit amet " +
                "ornare urna. Duis pretium, metus at sollicitudin sollicitudin, tellus urna mollis " +
                "dui, a efficitur nullam.");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long descritpion.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue(errors.hasErrors());
    }

    @Test
    public void testValidatorWithTooLongCity() {
        advertisementForm.setCity("WarsawCracovBreslauDanzigMlawa1");

        Errors errors = new BeanPropertyBindingResult(advertisementForm, "Too long city name.");
        advertisementFormValidator.validate(advertisementForm, errors);

        assertTrue(errors.hasErrors());
    }
}
