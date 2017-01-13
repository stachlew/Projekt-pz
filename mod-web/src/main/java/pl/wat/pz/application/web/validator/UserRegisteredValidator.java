package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.User.UserRegistered;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegisteredValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistered.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegistered userRegistered = (UserRegistered) target;

        if(userRegistered.getUsername() == null) {
            errors.rejectValue("username", "Empty username.");
        }
        else {
            if(userRegistered.getUsername().length() < 4 || userRegistered.getUsername().length() > 50) {
                errors.rejectValue("username", "Wrong size of username.");
            }
        }

        if(userRegistered.getPassword() == null) {
            errors.rejectValue("password", "Empty password.");
        }
        else {
            if(userRegistered.getPassword().length() < 4 || userRegistered.getPassword().length() > 255) {
                errors.rejectValue("password", "Wrong size of password.");
            }
        }

        if(userRegistered.getMail() == null) {
            errors.rejectValue("mail", "Mail is empty.");
        }
        else {
            if(userRegistered.getMail().length() <= 50) {
                Pattern pattern; // wyrażenie regularne
                Matcher matcher; // porównanie z jakąś wartością
                boolean found; // pasuje/nie pasuje

                pattern = Pattern.compile("[a-z]+[a-zA-Z0-9_.-]*@[a-zA-Z0-9.]+[a-z]+$");
                matcher = pattern.matcher(userRegistered.getMail().toLowerCase());
                found = matcher.matches();

                if(!found) {
                    errors.rejectValue("mail", "Wrong format of mail.");
                }
            }
            else {
                errors.rejectValue("mail", "Too long mail.");
            }
        }

        if(userRegistered.getPhone() != null) {
            if(userRegistered.getPhone().length() <= 15) {
                try {
                    Long.parseLong(userRegistered.getPhone());
                }
                catch (NumberFormatException e) {
                    errors.rejectValue("phone", "Wrong phone number.");
                }
            }
            else {
                errors.rejectValue("phone", "Too long phone number.");
            }
        }

        if(userRegistered.getCity() != null) {
            if(userRegistered.getCity().length() > 30) {
                errors.rejectValue("city", "Too long city.");
            }
        }

        if(userRegistered.getRegionName() != null) {
            if(userRegistered.getRegionName().length() > 20) {
                errors.rejectValue("regionName", "Too long region name.");
            }
        }
    }
}
