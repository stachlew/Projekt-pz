package pl.wat.pz.application.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.wat.pz.application.dao.intermediateClass.Message.MessageForm;

public class MessageFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return MessageForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MessageForm messageForm = (MessageForm) target;

        if(messageForm.getText().length() < 1 || messageForm.getText().length() > 1000) {
            errors.rejectValue("text", "Wrong length of message text.");
        }
    }
}
