package aud1.test;

import aud1.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTest {

    public Message message = new Message("test message");

    //gi testiram metodite

    @Test
    public void salutationMessage(){
        Assertions.assertEquals("Hello!", message.salutationMessage()); //expected and actual
    }

    @Test
    public void goodbyeMessage(){
        Assertions.assertEquals("Goodbye!", message.goodbyeMessage());
    }

    @Test
    public void setMessage(){
        String messageText = "New text message";
        Assertions.assertEquals(messageText, message.setMessage(messageText));
    }

}
