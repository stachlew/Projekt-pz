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

        if(advertisementForm.getTitle() == null) {
            errors.rejectValue("title", "Empty title.");
        }
        else {
            if(advertisementForm.getTitle().length() < 4 || advertisementForm.getTitle().length() > 250) {
                errors.rejectValue("title", "Wrong length of title.");
            }
        }

        if(advertisementForm.getBailValue() >= 0) {
            if(Double.toString(advertisementForm.getBailValue()).length() > 10) {
                errors.rejectValue("bailValue", "Too big bailValue.");
            }
        }
        else {
            errors.rejectValue("bailValue", "Wrong bailValue.");
        }

        if(advertisementForm.getChargePerDay() >= 0) {
            if(Double.toString(advertisementForm.getChargePerDay()).length() > 10) {
                errors.rejectValue("chargePerDay", "Too big chargePerDay.");
            }
        }
        else {
            errors.rejectValue("chargePerDay", "Wrong chargePerDay.");
        }

        if(advertisementForm.getDescription() != null) {
            if(advertisementForm.getDescription().length() > 500) {
                errors.rejectValue("description", "Too long description.");
            }
        }

        if(advertisementForm.getCity() == null) {
            errors.rejectValue("city", "Empty city.");
        }
        else {
            if(advertisementForm.getCity().length() > 30) {
                errors.rejectValue("city", "Too long city name.");
            }
        }

        if(advertisementForm.getRegion() == null) {
            errors.rejectValue("region", "Empty region.");
        }
        else {
            if (advertisementForm.getRegion().length() > 20) {
                errors.rejectValue("region", "Too long region.");
            }
        }

        if(advertisementForm.getCategory() == null) {
            errors.rejectValue("category", "Empty category.");
        }
        else {
            if(advertisementForm.getCategory().length() > 20) {
                errors.rejectValue("category", "Too long category.");
            }
        }
    }
}
