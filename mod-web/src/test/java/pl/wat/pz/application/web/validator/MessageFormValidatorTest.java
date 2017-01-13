package pl.wat.pz.application.web.validator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import pl.wat.pz.application.dao.intermediateClass.Message.MessageForm;

public class MessageFormValidatorTest extends TestCase {
    private MessageForm messageForm;
    private MessageFormValidator messageFormValidator;

    public MessageFormValidatorTest(String name) {
        super(name);
    }

    @Before
    public void setUp() {
        messageForm = new MessageForm();
        messageFormValidator = new MessageFormValidator();
    }

    @Test
    public void test_message_text_is_too_short() {
        messageForm.setText("");

        Errors errors = new BeanPropertyBindingResult(messageForm, "Text of message is too short.");
        messageFormValidator.validate(messageForm, errors);

        assertTrue("Text of message is too short.", errors.hasErrors());
    }

    @Test
    public void test_message_text_is_too_long() {
        messageForm.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas quis " +
                "urna velit. Nulla sodales, enim vel aliquet varius, dolor purus placerat orci, sit " +
                "amet pellentesque nisl leo id ligula. Praesent sollicitudin, quam sit amet lobortis " +
                "finibus, eros augue tempor lacus, vel lobortis tortor eros nec est. Mauris laoreet a " +
                "dolor gravida porta. Mauris dignissim, dui eu fringilla congue, ex purus bibendum orci, " +
                "vitae eleifend sem sem ac neque. Pellentesque aliquet sed odio a suscipit. Aliquam volutpat " +
                "cursus tempus. Donec ac lacus sapien. Vestibulum gravida metus sed velit molestie tempus. " +
                "Vivamus mollis pulvinar libero, ac pharetra turpis faucibus non. Nam quis lacus non urna " +
                "sagittis aliquam. Maecenas viverra scelerisque libero, eu accumsan justo scelerisque eu. " +
                "Nam porttitor sodales malesuada. In tincidunt sed erat et maximus. Morbi justo augue, " +
                "fermentum placerat leo eget, euismod dapibus orci. Maecenas vel libero urna. Cras quis " +
                "leo nec leo laoreet egestas. Vestibulum pellentesque sed.");

        Errors errors = new BeanPropertyBindingResult(messageForm, "Text of message is too long.");
        messageFormValidator.validate(messageForm, errors);

        assertTrue("Text of message is too long.", errors.hasErrors());
    }

    @Test
    public void test_message_form_is_correct() {
        messageForm.setText("I want to borrow it.");

        Errors errors = new BeanPropertyBindingResult(messageForm, "Message form is correct.");
        messageFormValidator.validate(messageForm, errors);

        assertFalse("Message form is correct.", errors.hasErrors());
    }
}
