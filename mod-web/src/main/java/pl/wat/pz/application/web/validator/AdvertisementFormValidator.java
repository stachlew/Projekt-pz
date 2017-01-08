package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementForm;

public class AdvertisementFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AdvertisementForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdvertisementForm advertisementForm = (AdvertisementForm) target;

        if(advertisementForm.getTitle().length() < 4) {
            errors.rejectValue("title", "Too short title.");
        }
        if(advertisementForm.getTitle().length() > 250) {
            errors.rejectValue("title", "Too long title.");
        }
        if(Double.toString(advertisementForm.getBailValue()).length() > 10) {
            errors.rejectValue("bailValue", "Too big bailValue.");
        }
        if(Double.toString(advertisementForm.getChargePerDay()).length() > 10) {
            errors.rejectValue("chargePerDay", "Too big chargePerDay.");
        }
        if(advertisementForm.getDescription() != null) {
            if(advertisementForm.getDescription().length() > 500) {
                errors.rejectValue("description", "Too long description.");
            }
        }
        if(advertisementForm.getCity().length() > 30) {
            errors.rejectValue("city", "Too long city name.");
        }
    }
}
