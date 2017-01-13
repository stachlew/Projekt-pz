package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.User.UserForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm userForm = (UserForm) target;

        if(userForm.getPassword() != null) {
            if(userForm.getPassword().length() > 255) {
                errors.rejectValue("password", "Too long password.");
            }
            else if(userForm.getPassword().length() < 4) {
                errors.rejectValue("password", "Too short password.");
            }
        }

        if(userForm.getMail() != null) {
            if(userForm.getMail().length() <= 50) {
                Pattern pattern; // wyrażenie regularne
                Matcher matcher; // porównanie z jakąś wartością
                boolean found; // pasuje/nie pasuje

                pattern = Pattern.compile("[a-z]+[a-zA-Z0-9_.-]*@[a-zA-Z0-9.]+[a-z]+$");
                matcher = pattern.matcher(userForm.getMail().toLowerCase());
                found = matcher.matches();

                if(!found) {
                    errors.rejectValue("mail", "Wrong format of mail.");
                }
            }
            else {
                errors.rejectValue("mail", "Too long mail.");
            }
        }

        if(userForm.getPhone() != null) {
            if(userForm.getPhone().length() <= 15) {
                try {
                    Long.parseLong(userForm.getPhone());
                } catch (NumberFormatException e) {
                    errors.rejectValue("phone", "Wrong phone number.");
                }
            }
            else {
                errors.rejectValue("phone", "Too long phone number.");
            }
        }

        if(userForm.getCity() != null) {
            if(userForm.getCity().length() > 30) {
                errors.rejectValue("city", "Too long city.");
            }
        }

        if(userForm.getRegionName() != null) {
            if(userForm.getRegionName().length() > 20) {
                errors.rejectValue("regionName", "Too long region name.");
            }
        }
    }
}
