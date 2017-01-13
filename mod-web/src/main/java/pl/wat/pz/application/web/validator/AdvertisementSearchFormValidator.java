package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.Advertisement.AdvertisementSearchForm;

public class AdvertisementSearchFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AdvertisementSearchForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdvertisementSearchForm advertisementSearchForm = (AdvertisementSearchForm) target;

        if(advertisementSearchForm.getTitle() != null) {
            if(advertisementSearchForm.getTitle().length() > 255) {
                errors.rejectValue("title", "Too long title.");
            }
        }

        if(advertisementSearchForm.getCategory() != null) {
            if(advertisementSearchForm.getCategory().length() > 20) {
                errors.rejectValue("category", "Too long category.");
            }
        }

        if(advertisementSearchForm.getRegion() != null) {
            if(advertisementSearchForm.getRegion().length() > 20) {
                errors.rejectValue("region", "Too long region.");
            }
        }

        if(advertisementSearchForm.getCity() != null) {
            if(advertisementSearchForm.getCity().length() > 30) {
                errors.rejectValue("city", "Too long city.");
            }
        }

        if(advertisementSearchForm.getChargePerDayFrom() != null) {
            try {
                Double.parseDouble(advertisementSearchForm.getChargePerDayFrom());
            } catch (NumberFormatException e) {
                errors.rejectValue("chargePerDayFrom", "ChargePerDayFrom - not a number.");
            }
        }

        if(advertisementSearchForm.getChargePerDayTo() != null) {
            try {
                Double.parseDouble(advertisementSearchForm.getChargePerDayTo());
            } catch (NumberFormatException e) {
                errors.rejectValue("chargePerDayTo", "ChargerPerDayTo - not a number.");
            }
        }

        if(advertisementSearchForm.getBailValueFrom() != null) {
            try {
                Double.parseDouble(advertisementSearchForm.getBailValueFrom());
            } catch (NumberFormatException e) {
                errors.rejectValue("bailValueFrom", "BailValueFrom - not a number.");
            }
        }

        if(advertisementSearchForm.getBailValueTo() != null) {
            try {
                Double.parseDouble(advertisementSearchForm.getBailValueTo());
            } catch (NumberFormatException e) {
                errors.rejectValue("bailValueTo", "BailValueTo - not a number.");
            }
        }
    }
}
